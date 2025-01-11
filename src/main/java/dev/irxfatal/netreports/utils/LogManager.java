package dev.irxfatal.netreports.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogManager {

    private static final String REPORT_LOG_PATH = "plugins/netreports/reports.log";

    public static void logReport(String reporter, String target, String reason) {
        try (FileWriter fileWriter = new FileWriter(REPORT_LOG_PATH, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println("Reporter: " + reporter + " | Target: " + target + " | Reason: " + reason);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
