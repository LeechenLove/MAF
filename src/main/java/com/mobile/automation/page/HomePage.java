package com.mobile.automation.page;

import com.google.inject.Inject;
import com.mobile.automation.contracts.Home;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * @Author: Lulu
 * @Description: TODO
 * @DateTime: 2022/7/10 21:10
 **/
public class HomePage extends BasePage implements Home {

    private final By welcomeLabel = By.id("tvWelcome");

    @Inject
    public HomePage(AppiumDriver appiumDriver){
        super(appiumDriver);
        this.uniqueLocator = By.id("tvGreeting");;
    }
}
