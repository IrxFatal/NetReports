package dev.irxfatal.netreports.storage;

import dev.irxfatal.netreports.utils.ApiUtil;

import java.util.List;
import java.util.Map;

public class ApiStorageHandler implements StorageHandler {

    private final String apiEndpoint;

    public ApiStorageHandler(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    @Override
    public boolean storeReport(String reporter, String target, String reason) {
        return ApiUtil.sendReportToApi(apiEndpoint, reporter, target, reason);
    }

    @Override
    public Map<String, List<String>> getGroupedReports() {
        return ApiUtil.getReportsFromApi(apiEndpoint);
    }

    @Override
    public String getLastReportTime(String player) {
        return ApiUtil.getLastReportTimeFromApi(apiEndpoint, player);
    }

    @Override
    public void close() {
    }
}
