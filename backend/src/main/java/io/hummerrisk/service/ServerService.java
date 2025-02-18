package io.hummerrisk.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.hummerrisk.base.domain.*;
import io.hummerrisk.base.mapper.*;
import io.hummerrisk.base.mapper.ext.ExtServerMapper;
import io.hummerrisk.base.mapper.ext.ExtServerResultMapper;
import io.hummerrisk.base.mapper.ext.ExtServerRuleMapper;
import io.hummerrisk.commons.constants.CloudAccountConstants;
import io.hummerrisk.commons.constants.ResourceOperation;
import io.hummerrisk.commons.constants.ResourceTypeConstants;
import io.hummerrisk.commons.constants.TaskConstants;
import io.hummerrisk.commons.exception.HRException;
import io.hummerrisk.commons.utils.BeanUtils;
import io.hummerrisk.commons.utils.LogUtil;
import io.hummerrisk.commons.utils.SessionUtils;
import io.hummerrisk.commons.utils.UUIDUtil;
import io.hummerrisk.controller.request.server.ServerRequest;
import io.hummerrisk.controller.request.server.ServerResultRequest;
import io.hummerrisk.controller.request.server.ServerRuleRequest;
import io.hummerrisk.dto.ServerDTO;
import io.hummerrisk.dto.ServerResultDTO;
import io.hummerrisk.dto.ServerRuleDTO;
import io.hummerrisk.i18n.Translator;
import io.hummerrisk.proxy.server.SshUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author harris
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ServerService {

    @Resource
    private ExtServerMapper extServerMapper;
    @Resource
    private ServerMapper serverMapper;
    @Resource
    private ServerGroupMapper serverGroupMapper;
    @Resource
    private ServerRuleMapper serverRuleMapper;
    @Resource
    private ExtServerRuleMapper extServerRuleMapper;
    @Resource
    private RuleTagMapper ruleTagMapper;
    @Resource
    private RuleTagMappingMapper ruleTagMappingMapper;
    @Resource
    private ExtServerResultMapper extServerResultMapper;
    @Resource
    private ServerResultMapper serverResultMapper;
    @Resource
    private ServerResultLogMapper serverResultLogMapper;

    public boolean validate(List<String> ids) {
        ids.forEach(id -> {
            try {
                boolean validate = validate(id);
                if(!validate) throw new HRException(Translator.get("failed_server"));
            } catch (Exception e) {
                LogUtil.error(e.getMessage());
                throw new HRException(e.getMessage());
            }
        });
        return true;
    }


    public boolean validate(String id) {
        Server server = serverMapper.selectByPrimaryKey(id);
        //检验虚拟机配置的有效性
        boolean valid = validateAccount(server);
        if (valid) {
            server.setStatus(CloudAccountConstants.Status.VALID.name());
        } else {
            server.setStatus(CloudAccountConstants.Status.INVALID.name());
        }
        serverMapper.updateByPrimaryKeySelective(server);
        return valid;
    }

    public Boolean scan(List<String> ids) {
        ids.forEach(id -> {
            try {
                scan(id);
            } catch (Exception e) {
                LogUtil.error(e.getMessage());
                throw new HRException(e.getMessage());
            }
        });
        return true;
    }

    public Boolean scan(String id) throws Exception{
            ServerRequest request = new ServerRequest();
            request.setId(id);
            Server server = getServerList(request).get(0);
            if(StringUtils.equalsIgnoreCase(server.getStatus(), CloudAccountConstants.Status.VALID.name())) {
                deleteServerResult(id);
                List<ServerRuleDTO> ruleList = ruleList(null);
                ServerResult result = new ServerResult();
                String serverGroupName = serverGroupMapper.selectByPrimaryKey(server.getServerGroupId()).getName();
                for(ServerRuleDTO dto : ruleList) {
                    BeanUtils.copyBean(result, server);
                    result.setId(UUIDUtil.newUUID());
                    result.setServerId(id);
                    result.setServerGroupId(server.getServerGroupId());
                    result.setServerGroupName(serverGroupName);
                    result.setApplyUser(SessionUtils.getUserId());
                    result.setCreateTime(System.currentTimeMillis());
                    result.setUpdateTime(System.currentTimeMillis());
                    result.setServerName(server.getName());
                    result.setRuleId(dto.getId());
                    result.setRuleName(dto.getName());
                    result.setRuleDesc(dto.getDescription());
                    result.setResultStatus(TaskConstants.TASK_STATUS.APPROVED.toString());
                    result.setSeverity(dto.getSeverity());
                    serverResultMapper.insertSelective(result);

                    saveServerResultLog(result.getId(), Translator.get("i18n_start_server_result"), "", true);

                    try {
                        String script = dto.getScript();
                        JSONArray jsonArray = JSON.parseArray(dto.getParameter());
                        for (Object o : jsonArray) {
                            JSONObject jsonObject = (JSONObject) o;
                            String key = "${{" + jsonObject.getString("key") + "}}";
                            if (script.contains(key)) {
                                script = script.replace(key, jsonObject.getString("defaultValue"));
                            }
                        }
                        String returnLog = execute(server.getIp(), server.getUserName(), server.getPassword(), script);
                        result.setReturnLog(returnLog);
                        result.setUpdateTime(System.currentTimeMillis());
                        result.setResultStatus(TaskConstants.TASK_STATUS.FINISHED.toString());
                        serverResultMapper.updateByPrimaryKeySelective(result);

                        saveServerResultLog(result.getId(), Translator.get("i18n_end_server_result"), returnLog, true);
                    } catch (Exception e) {
                        LogUtil.error(e.getMessage());
                        result.setUpdateTime(System.currentTimeMillis());
                        result.setResultStatus(TaskConstants.TASK_STATUS.ERROR.toString());
                        serverResultMapper.updateByPrimaryKeySelective(result);
                        saveServerResultLog(result.getId(), Translator.get("i18n_operation_ex") + ": " + e.getMessage(), e.getMessage(), false);
                        throw new HRException(e.getMessage());
                    }
                }
            }
        return true;
    }

    public void rescan(String id) {
        ServerResult result = serverResultMapper.selectByPrimaryKey(id);
        ServerRule rule = serverRuleMapper.selectByPrimaryKey(result.getRuleId());
        saveServerResultLog(result.getId(), Translator.get("i18n_restart_server_result"), "", true);

        try {
            String script = rule.getScript();
            JSONArray jsonArray = JSON.parseArray(rule.getParameter());
            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                String key = "${{" + jsonObject.getString("key") + "}}";
                if (script.contains(key)) {
                    script = script.replace(key, jsonObject.getString("defaultValue"));
                }
            }
            String returnLog = execute(result.getIp(), result.getUserName(), result.getPassword(), script);
            result.setReturnLog(returnLog);
            result.setUpdateTime(System.currentTimeMillis());
            result.setResultStatus(TaskConstants.TASK_STATUS.FINISHED.toString());
            serverResultMapper.updateByPrimaryKeySelective(result);

            saveServerResultLog(result.getId(), Translator.get("i18n_end_server_result"), returnLog, true);
        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            result.setUpdateTime(System.currentTimeMillis());
            result.setResultStatus(TaskConstants.TASK_STATUS.ERROR.toString());
            serverResultMapper.updateByPrimaryKeySelective(result);
            saveServerResultLog(result.getId(), Translator.get("i18n_operation_ex") + ": " + e.getMessage(), e.getMessage(), false);
            throw new HRException(e.getMessage());
        }
    }

    public void deleteServerResult(String id) {
        ServerResultExample example = new ServerResultExample();
        example.createCriteria().andIdEqualTo(id);
        List<ServerResult> list = serverResultMapper.selectByExample(example);

        for (ServerResult result : list) {
            ServerResultLogExample logExample = new ServerResultLogExample();
            logExample.createCriteria().andResultIdEqualTo(result.getRuleId());
            serverResultLogMapper.deleteByExample(logExample);
        }
        serverResultMapper.deleteByExample(example);
    }

    void saveServerResultLog(String resultId, String operation, String output, boolean result) {
        ServerResultLog serverResultLog = new ServerResultLog();
        String operator = "system";
        try {
            if (SessionUtils.getUser() != null) {
                operator = SessionUtils.getUser().getId();
            }
        } catch (Exception e) {
            //防止单元测试无session
        }
        serverResultLog.setOperator(operator);
        serverResultLog.setResultId(resultId);
        serverResultLog.setCreateTime(System.currentTimeMillis());
        serverResultLog.setOperation(operation);
        serverResultLog.setOutput(output);
        serverResultLog.setResult(result);
        serverResultLogMapper.insertSelective(serverResultLog);
    }

    private boolean validateAccount(Server server) {
        try {
            return login(server.getIp(), server.getUserName(), server.getPassword());
        } catch (Exception e) {
            LogUtil.error(String.format("HRException in verifying server, server: [%s], ip: [%s], error information:%s", server.getName(), server.getIp(), e.getMessage()), e);
            return false;
        }
    }

    public List<ServerGroup> getServerGroupList() {
        return serverGroupMapper.selectByExample(null);
    }

    public List<ServerDTO> getServerList(ServerRequest server) {
        return extServerMapper.getServerList(server);
    }

    public int addServerGroup(ServerGroup serverGroup) {
        serverGroup.setId(UUIDUtil.newUUID());
        serverGroup.setCreator(SessionUtils.getUserId());
        serverGroup.setCreateTime(System.currentTimeMillis());
        serverGroup.setUpdateTime(System.currentTimeMillis());
        OperationLogService.log(SessionUtils.getUser(), serverGroup.getId(), serverGroup.getId(), ResourceTypeConstants.SERVER.name(), ResourceOperation.CREATE, "创建虚拟机分组");

        return serverGroupMapper.insertSelective(serverGroup);
    }

    public int editServerGroup(ServerGroup serverGroup) {
        serverGroup.setUpdateTime(System.currentTimeMillis());
        OperationLogService.log(SessionUtils.getUser(), serverGroup.getId(), serverGroup.getId(), ResourceTypeConstants.SERVER.name(), ResourceOperation.UPDATE, "更新虚拟机分组");
        return serverGroupMapper.updateByPrimaryKeySelective(serverGroup);
    }

    public void deleteServerGroup(ServerGroup serverGroup) {

        ServerExample example = new ServerExample();
        example.createCriteria().andServerGroupIdEqualTo(serverGroup.getId());
        List<Server> list = serverMapper.selectByExample(example);
        if (list.size() > 0) {
            HRException.throwException(Translator.get("i18n_ex_server_validate"));
        } else {
            serverGroupMapper.deleteByPrimaryKey(serverGroup.getId());
        }
        OperationLogService.log(SessionUtils.getUser(), serverGroup.getId(), serverGroup.getId(), ResourceTypeConstants.SERVER.name(), ResourceOperation.DELETE, "删除虚拟机分组");

    }

    public int addServer(Server server) throws Exception {
        String id = UUIDUtil.newUUID();
        server.setId(id);
        server.setCreator(SessionUtils.getUserId());
        server.setCreateTime(System.currentTimeMillis());
        server.setUpdateTime(System.currentTimeMillis());
        server.setStatus(login(server.getIp(), server.getUserName(), server.getPassword())?CloudAccountConstants.Status.VALID.name():CloudAccountConstants.Status.INVALID.name());

        OperationLogService.log(SessionUtils.getUser(), server.getId(), server.getName(), ResourceTypeConstants.SERVER.name(), ResourceOperation.CREATE, "创建虚拟机");
        return serverMapper.insertSelective(server);
    }

    public int editServer(Server server) throws Exception {
        server.setUpdateTime(System.currentTimeMillis());
        server.setStatus(login(server.getIp(), server.getUserName(), server.getPassword())?CloudAccountConstants.Status.VALID.name():CloudAccountConstants.Status.INVALID.name());

        OperationLogService.log(SessionUtils.getUser(), server.getId(), server.getName(), ResourceTypeConstants.SERVER.name(), ResourceOperation.UPDATE, "更新虚拟机");
        return serverMapper.updateByPrimaryKeySelective(server);
    }

    public void deleteServer(String id) throws Exception {
        serverMapper.deleteByPrimaryKey(id);
        OperationLogService.log(SessionUtils.getUser(), id, id, ResourceTypeConstants.SERVER.name(), ResourceOperation.DELETE, "删除虚拟机");
    }

    public boolean login(String sshIp, String sshUsername, String sshPassword) throws Exception {
        try {
            SshUtil.login(sshIp, sshUsername, sshPassword);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public String execute(String sshIp, String sshUsername, String sshPassword, String cmd) throws Exception {
        try {
            return SshUtil.execute(SshUtil.login(sshIp, sshUsername, sshPassword), cmd);
        }catch (Exception e) {
            return "";
        }
    }

    public List<ServerRuleDTO> ruleList(ServerRuleRequest request) {
        return extServerRuleMapper.ruleList(request);
    }

    public int addServerRule(ServerRuleRequest request) throws Exception {
        ServerRule record = new ServerRule();
        BeanUtils.copyBean(record, request);
        record.setId(UUIDUtil.newUUID());
        record.setLastModified(System.currentTimeMillis());
        saveRuleTagMapping(record.getId(), request.getTagKey());
        return serverRuleMapper.insertSelective(record);
    }

    public void saveRuleTagMapping(String ruleId, String tagKey) {
        deleteRuleTag(null, ruleId);
        if (StringUtils.isNotEmpty(tagKey)) {
            RuleTagMapping sfRulesTagMapping = new RuleTagMapping();
            sfRulesTagMapping.setRuleId(ruleId);
            sfRulesTagMapping.setTagKey(tagKey);
            ruleTagMappingMapper.insert(sfRulesTagMapping);
        }
    }

    public void deleteRuleTag(String tagkey, String ruleId) {
        if (StringUtils.isNotBlank(tagkey)) {
            ruleTagMapper.deleteByPrimaryKey(tagkey);
            RuleTagExample ruleTagExample = new RuleTagExample();
            ruleTagExample.createCriteria().andTagKeyEqualTo(tagkey);
            ruleTagMapper.deleteByExample(ruleTagExample);
        }
        if (StringUtils.isNotBlank(ruleId)) {
            RuleTagMappingExample ruleTagMappingExample = new RuleTagMappingExample();
            ruleTagMappingExample.createCriteria().andRuleIdEqualTo(ruleId);
            ruleTagMappingMapper.deleteByExample(ruleTagMappingExample);
        }
    }

    public int updateServerRule(ServerRuleRequest request) throws Exception {
        ServerRule record = new ServerRule();
        BeanUtils.copyBean(record, request);
        record.setLastModified(System.currentTimeMillis());
        saveRuleTagMapping(record.getId(), request.getTagKey());
        return serverRuleMapper.updateByPrimaryKeySelective(record);
    }

    public void deleteServerRule(String id) throws Exception {
        deleteRuleTag(null, id);
        serverRuleMapper.deleteByPrimaryKey(id);
    }

    public int changeStatus(ServerRule rule) throws Exception {
        return serverRuleMapper.updateByPrimaryKeySelective(rule);
    }

    public List<ServerResultDTO> resultList(ServerResultRequest request) {
        return extServerResultMapper.resultList(request);
    }

    public List<ServerResultLog> getServerResultLog(String resultId) {
        ServerResultLogExample example = new ServerResultLogExample();
        example.createCriteria().andResultIdEqualTo(resultId);
        return serverResultLogMapper.selectByExampleWithBLOBs(example);
    }
}
