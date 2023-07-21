package com.Tests.TestCases;

import com.Support.Utils;
import com.Tests.Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssessmentTest extends BaseClass {


    Utils utils = new Utils();
    Locators locators = new Locators();


    @Test
    public void assessmentTest() throws Exception {
        driver.findElement(locators.userName).sendKeys(utils.getProperty().getProperty("userName"));
        driver.findElement(locators.password).sendKeys(utils.getProperty().getProperty("password"));
        driver.findElement(locators.loginButton).click();
        Thread.sleep(8000);
        driver.findElement(locators.manageUser).click();
        driver.findElement(locators.createUser).click();
        driver.findElement(locators.inviteUser).click();
        driver.findElement(locators.enterEmail).sendKeys(utils.getProperty().getProperty("Email"));
        driver.findElement(locators.clickOther).click();
        Thread.sleep(1000);
        driver.findElement(locators.sendButton).click();
        Thread.sleep(8000);
        String message = driver.findElement(locators.message).getText();
        Assert.assertEquals(" User(s) Invited Successfully ", message);
    }
}
