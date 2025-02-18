package io.hummerrisk.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.hummerrisk.base.domain.Server;
import io.hummerrisk.base.domain.ServerGroup;
import io.hummerrisk.base.domain.ServerResultLog;
import io.hummerrisk.base.domain.ServerRule;
import io.hummerrisk.commons.utils.PageUtils;
import io.hummerrisk.commons.utils.Pager;
import io.hummerrisk.controller.request.server.ServerRequest;
import io.hummerrisk.controller.request.server.ServerResultRequest;
import io.hummerrisk.controller.request.server.ServerRuleRequest;
import io.hummerrisk.dto.ServerDTO;
import io.hummerrisk.dto.ServerResultDTO;
import io.hummerrisk.dto.ServerRuleDTO;
import io.hummerrisk.service.ServerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "虚拟机配置")
@RestController
@RequestMapping(value = "server")
public class ServerController {
    @Resource
    private ServerService serverService;

    @ApiOperation(value = "所有虚拟机分组")
    @GetMapping("serverGroupList")
    public List<ServerGroup> getServerGroupList() {
        return serverService.getServerGroupList();
    }

    @ApiOperation(value = "虚拟机列表")
    @PostMapping("serverList/{goPage}/{pageSize}")
    public Pager<List<ServerDTO>> getServerList(
            @PathVariable int goPage, @PathVariable int pageSize, @RequestBody ServerRequest server) {
        Page<Object> page = PageHelper.startPage(goPage, pageSize, true);
        return PageUtils.setPageInfo(page, serverService.getServerList(server));
    }

    @ApiOperation(value = "批量校验虚拟机配置")
    @PostMapping("validate")
    public Boolean validate(@RequestBody List<String> selectIds) {
        return serverService.validate(selectIds);
    }

    @ApiOperation(value = "校验虚拟机配置")
    @PostMapping("validate/{id}")
    public Boolean validate(@PathVariable String id) {
        return serverService.validate(id);
    }

    @ApiOperation(value = "一键扫描虚拟机规则")
    @PostMapping("scan")
    public Boolean scan(@RequestBody List<String> selectIds) {
        return serverService.scan(selectIds);
    }

    @ApiOperation(value = "添加虚拟机分组")
    @PostMapping("addServerGroup")
    public int addServerGroup(@RequestBody ServerGroup serverGroup) {
        return serverService.addServerGroup(serverGroup);
    }

    @ApiOperation(value = "修改虚拟机分组")
    @PostMapping("editServerGroup")
    public int editServerGroup(@RequestBody ServerGroup serverGroup) throws Exception {
        return serverService.editServerGroup(serverGroup);
    }

    @ApiOperation(value = "删除虚拟机分组")
    @PostMapping("deleteServerGroup")
    public void deleteServerGroup(@RequestBody ServerGroup serverGroup) throws Exception {
        serverService.deleteServerGroup(serverGroup);
    }

    @ApiOperation(value = "添加虚拟机")
    @PostMapping("addServer")
    public int addServer(@RequestBody Server server) throws Exception {
        return serverService.addServer(server);
    }

    @ApiOperation(value = "编辑虚拟机")
    @PostMapping("editServer")
    public int editServer(@RequestBody Server server) throws Exception {
        return serverService.editServer(server);
    }

    @ApiOperation(value = "删除虚拟机")
    @GetMapping("deleteServer/{id}")
    public void deleteServer(@PathVariable String id) throws Exception {
        serverService.deleteServer(id);
    }

    @ApiOperation(value = "虚拟机规则列表")
    @PostMapping(value = "ruleList/{goPage}/{pageSize}")
    public Pager<List<ServerRuleDTO>> ruleList(@PathVariable int goPage, @PathVariable int pageSize, @RequestBody ServerRuleRequest request) {
        Page<Object> page = PageHelper.startPage(goPage, pageSize, true);
        return PageUtils.setPageInfo(page, serverService.ruleList(request));
    }

    @ApiOperation(value = "添加虚拟机规则")
    @PostMapping(value = "addServerRule")
    public int addServerRule(@RequestBody ServerRuleRequest request) throws Exception {
        request.setId(null);
        return serverService.addServerRule(request);
    }

    @ApiOperation(value = "修改虚拟机规则")
    @PostMapping(value = "updateServerRule")
    public int updateServerRule(@RequestBody ServerRuleRequest request) throws Exception {
        return serverService.updateServerRule(request);
    }

    @ApiOperation(value = "删除虚拟机规则")
    @GetMapping(value = "deleteServerRule/{id}")
    public void deleteServerRule(@PathVariable String id) throws Exception  {
        serverService.deleteServerRule(id);
    }

    @ApiOperation(value = "虚拟机规则启用")
    @PostMapping(value = "changeStatus")
    public int changeStatus(@RequestBody ServerRule rule) throws Exception {
        return serverService.changeStatus(rule);
    }

    @ApiOperation(value = "虚拟机扫描结果列表")
    @PostMapping(value = "resultList/{goPage}/{pageSize}")
    public Pager<List<ServerResultDTO>> resultList(@PathVariable int goPage, @PathVariable int pageSize, @RequestBody ServerResultRequest request) {
        Page<Object> page = PageHelper.startPage(goPage, pageSize, true);
        return PageUtils.setPageInfo(page, serverService.resultList(request));
    }

    @ApiOperation(value = "虚拟机扫描日志")
    @GetMapping(value = "log/{resultId}")
    public List<ServerResultLog> getServerResultLog(@PathVariable String resultId) {
        return serverService.getServerResultLog(resultId);
    }

    @ApiOperation(value = "重新扫描虚拟机规则")
    @GetMapping("restart/{id}")
    public void restartResource(@PathVariable String id) throws Exception {
        serverService.rescan(id);
    }

    @ApiOperation(value = "删除虚拟机扫描记录")
    @GetMapping("deleteServerResult/{id}")
    public void deleteServerResult(@PathVariable String id) throws Exception {
        serverService.deleteServerResult(id);
    }

}
