package com.mobile.automation.page;

import com.mobile.automation.util.AppiumHelper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Lulu
 * @Description: page基类，用于page类的继承
 * @DateTime: 2022/7/10 16:36
 **/
public abstract class BasePage implements Base{

    private Logger log;

    protected AppiumDriver appiumDriver;
    protected AppiumHelper appiumHelper;
    protected By uniqueLocator;

    public BasePage(AppiumDriver appiumDriver, AppiumHelper appiumHelper){
        this.appiumDriver = appiumDriver;
        this.appiumHelper = appiumHelper;
        PageFactory.initElements(appiumDriver, this);
        log = LoggerFactory.getLogger(BasePage.class);
    }

    @Override
    public boolean isDisplay(Integer... seconds) {
        return appiumHelper.checkElementIsDisplayed(uniqueLocator, seconds);
    }

    @Override
    public void waitDisplay(){
        appiumHelper.waitForElementByLocator(uniqueLocator);
    }
}
