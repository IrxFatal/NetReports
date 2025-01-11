package dev.irxfatal.netreports.storage;

import java.util.List;
import java.util.Map;

public interface StorageHandler {

    boolean storeReport(String reporter, String target, String reason);

    Map<String, List<String>> getGroupedReports();

    String getLastReportTime(String player);

    void close();
}
