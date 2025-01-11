package dev.irxfatal.netreports.storage;

import dev.irxfatal.netreports.utils.LogManager;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalStorageHandler implements StorageHandler {

    private final File dbFile;

    public LocalStorageHandler(String path) {
        this.dbFile = new File(path + "/reports.db");
        if (!dbFile.exists()) {
            try {
                dbFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean storeReport(String reporter, String target, String reason) {
        LogManager.logReport(reporter, target, reason);
        return true;
    }

    @Override
    public Map<String, List<String>> getGroupedReports() {
        Map<String, List<String>> reports = new HashMap<>();
        reports.put("Player1", List.of("Report1", "Report2"));
        reports.put("Player2", List.of("Report3"));
        return reports;
    }

    @Override
    public String getLastReportTime(String player) {
        return "2025-01-10 10:00:00";
    }

    @Override
    public void close() {
    }
}
