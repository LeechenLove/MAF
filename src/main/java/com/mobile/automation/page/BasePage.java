package com.mobile.automation.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Lulu
 * @Description: TODO
 * @DateTime: 2022/7/10 16:36
 **/
public abstract class BasePage implements Base{

    private Logger log;

    protected AppiumDriver appiumDriver;
    protected By uniqueLocator;

    public BasePage(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
        log = LoggerFactory.getLogger(BasePage.class);
    }

    @Override
    public boolean isDisplay(Integer... seconds) throws InterruptedException {
        Thread.sleep(2000);
        return appiumDriver.findElement(uniqueLocator).isDisplayed();
    }

    @Override
    public void waitDisplay(){
        appiumDriver.findElement(uniqueLocator).isDisplayed();
    }
}
