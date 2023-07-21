package com.Tests.Listeners;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.Support.ExtentReport;
import com.Tests.Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listeners extends BaseClass implements ITestListener {

    /**
     * This method will execute on test case Start
     *
     * @param result
     */
    @Override
    public void onTestStart(ITestResult result) {
        extentTest = ExtentReport.extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
    }

    /**
     * this method will execute when test execution success
     *
     * @param result
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        String logText = "<b>" + result.getMethod().getMethodName() + " -> Pass</b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.log(Status.PASS, markup);
    }

    /**
     * This method will execute on Test Execution failure
     *
     * @param result
     */
    @Override
    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = takesScreenshot(driver, result.getMethod().getMethodName());
            try {
                extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
            String logText = "<b> " + result.getMethod().getMethodName() + " -> failed</b>";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            extentTest.log(Status.FAIL, markup);
        }
    }

    /**
     * This method will Execute when test Execution will Skipped
     *
     * @param result
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        String logText = "<b> " + result.getMethod().getMethodName() + " -> Skip</b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        extentTest.log(Status.SKIP, markup);
    }

    /**
     * This Method Will Execute when test Execution will Finish
     *
     * @param context
     */
    @Override
    public void onFinish(ITestContext context) {
        if (ExtentReport.extent != null) {
            ExtentReport.extent.flush();
        }
    }

    /**
     * this Method will generate Screen Shot
     *
     * @param driver
     * @param methodName
     * @return path
     */
    public String takesScreenshot(WebDriver driver, String methodName) {
        String fileName = getscreenshotName(methodName);
        String directory = System.getProperty("user.dir") + "\\src\\ScreenShots";
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdirs();
        }
        String path = file + fileName;
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * This method will generate ScreenShot Name at Run Time
     *
     * @param methodName
     * @return methodName
     */
    public static String getscreenshotName(String methodName) {
        Date d = new Date();
        return methodName + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
    }
}
