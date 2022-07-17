package com.mobile.automation.page;

import com.google.inject.Inject;
import com.mobile.automation.contracts.Home;
import com.mobile.automation.util.AppiumHelper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * @Author: Lulu
 * @Description: Home page
 * @DateTime: 2022/7/10 21:10
 **/
public class HomePage extends BasePage implements Home {

    private final By welcomeLabel = By.id("tvWelcome");

    @Inject
    public HomePage(AppiumDriver appiumDriver, AppiumHelper appiumHelper){
        super(appiumDriver, appiumHelper);
        this.uniqueLocator = By.id("tvGreeting");;
    }
}
