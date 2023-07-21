package com.Support;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.util.Date;

public class ExtentReport {
    public static ExtentReports extent;

    /**
     * this Method will create Extent Report.
     * @return extent
     */
    public static ExtentReports createReport() {
        extent = new ExtentReports();
        String fileName = getReportName();
        String directory = System.getProperty("user.dir") + "\\src\\Reports";
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdirs();
        }
        String path = file + fileName;
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Test Automation Report");
        extent.attachReporter(reporter);
        return extent;
    }

    /**
     * this Method will Return Dynamic name for Extent Report.
     * @return fileName
     */
    public static String getReportName() {
        Date d = new Date();
        String fileName = "Automation_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
        return fileName;
    }
}
