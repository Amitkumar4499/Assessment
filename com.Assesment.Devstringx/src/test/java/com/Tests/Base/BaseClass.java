package com.Tests.Base;

import com.Support.ExtentReport;
import com.Support.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    public static WebDriver driver;

    public ExtentReports extent = ExtentReport.createReport();
    public ExtentTest extentTest;

    Utils utils = new Utils();

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(utils.getProperty().getProperty("URL"));
    }

    @AfterTest
    public void close() {
        driver.quit();
    }

}
