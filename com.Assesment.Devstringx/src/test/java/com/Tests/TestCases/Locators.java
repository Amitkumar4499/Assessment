package com.Tests.TestCases;

import com.Support.Utils;
import org.openqa.selenium.By;

public class Locators {

    Utils utils = new Utils();
    String newUser = utils.getProperty().getProperty("Email");
    By userName = By.xpath("//input[@id='email']");
    By password = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@id='loginBtbn']");
    By manageUser = By.xpath("//a[@class='sidebarOptionsList']//span[text()=' Manage Users & Groups']");
    By createUser = By.xpath("//div[text()=' Create ']");
    By inviteUser = By.xpath("//span[text()=' Invite User ']");
    By enterEmail = By.xpath("//input[@placeholder='Enter email addresses']");
    By clickOther = By.xpath("//div[text()=' You can invite user by entering single email address or by ']");
    By sendButton = By.xpath("//button[@id='sendbtn']");
    By message = By.xpath("//div[text()=' " + newUser + " ']");
}
