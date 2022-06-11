package com.mobile.automation.page;

import com.google.inject.Inject;
import com.mobile.automation.contracts.OpenApp;
import io.appium.java_client.AppiumDriver;

/**
 * @Author: Lulu
 * @Description: TODO
 * @DateTime: 2022/6/10 19:30
 **/
public class OpenAppPage implements OpenApp {
    private AppiumDriver appiumDriver;

    @Inject
    public OpenAppPage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    @Override
    public void startApp() {
        System.out.println(appiumDriver.getStatus());
    }
}
