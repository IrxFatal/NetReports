package dev.irxfatal.netreports.utils;

import java.util.List;
import java.util.Map;

public class ApiUtil {

    public static boolean sendReportToApi(String apiEndpoint, String reporter, String target, String reason) {
        return true;
    }

    public static Map<String, List<String>> getReportsFromApi(String apiEndpoint) {
        return Map.of("Player1", List.of("Report1", "Report2"));
    }

    public static String getLastReportTimeFromApi(String apiEndpoint, String player) {
        return "2025-01-10 10:00:00";
    }
}
