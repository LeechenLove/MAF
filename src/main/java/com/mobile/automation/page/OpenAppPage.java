package com.mobile.automation.page;

import com.google.inject.Inject;
import com.mobile.automation.contracts.OpenApp;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * @Author: Lulu
 * @Description: TODO
 * @DateTime: 2022/6/10 19:30
 **/
public class OpenAppPage extends BasePage implements OpenApp {

    private final By usernameTextBox = By.id("etUserName");
    private final By passwordTextBox = By.id("etPassword");
    private final By loginButton = By.id("btnLogin");
    private final By attemptCounterLabel = By.id("tvAttemptsInfo");

    @Inject
    public OpenAppPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }

    @Override
    public void startApp() {
        System.out.println(appiumDriver.getStatus());
    }

    public void setUsername(String username){
        appiumDriver.findElement(usernameTextBox).sendKeys(username);
    }

    public void setPassword(String password){
        appiumDriver.findElement(passwordTextBox).sendKeys(password);
    }

    @Override
    public void logonApp(String username, String password) {
        setUsername(username);
        setPassword(password);
        appiumDriver.findElement(loginButton).click();
    }

}
