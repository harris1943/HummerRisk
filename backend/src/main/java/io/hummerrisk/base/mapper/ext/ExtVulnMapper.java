package io.hummerrisk.base.mapper.ext;


import io.hummerrisk.commons.utils.ChartData;
import io.hummerrisk.commons.utils.DashboardTarget;
import io.hummerrisk.dto.ScanHistoryDTO;

import java.util.List;
import java.util.Map;

/**
 * @author harris
 */
public interface ExtVulnMapper {

    List<ChartData> overall(Map<String, Object> params);

    List<ChartData> ruleGroup(Map<String, Object> params);

    List<ChartData> report(Map<String, Object> params);

    List<ChartData> ruleList(Map<String, Object> params);

    List<ChartData> accountList(Map<String, Object> params);

    List<ChartData> regionsList(Map<String, Object> params);

    List<Map<String, Object>> severityList(Map<String, Object> params);

    List<Map<String, Object>> totalPolicy(Map<String, Object> params);

    List<DashboardTarget> target(Map<String, Object> params);

    List<ScanHistoryDTO> history(Map<String, Object> params);
}
