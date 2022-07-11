package com.mobile.automation.util;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ProtocolException;
import java.time.Duration;

/**
 * @Author: Lulu
 * @Description: 封装Appium方法
 * @DateTime: 2022/7/10 22:10
 **/
public class AppiumHelper {

    private static final Logger log = LoggerFactory.getLogger(AppiumHelper.class);
    private final AppiumDriver appiumDriver;
    private WebDriverWait webDriverWait;

    @Inject
    public AppiumHelper(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
//        this.webDriverWait = (WebDriverWait)
//                new WebDriverWait(appiumDriver, Duration.ofSeconds(20), Duration.ofMillis(10))
//                        .ignoring(NoSuchElementException.class);
    }

    WebDriverWait webDriverWaitForTime(Integer... time){
        Integer waitTime = time.length > 0 ? time[0] : DefaultTime.WAIT_TIME.getTime();
        return (WebDriverWait)
                new WebDriverWait(this.appiumDriver, Duration.ofSeconds(waitTime), Duration.ofMillis(10))
                        .ignoring(NoSuchElementException.class)
                        .ignoring(WebDriverException.class)
                        .ignoring(UnreachableBrowserException.class)
                        .ignoring(ProtocolException.class);
    }

    public WebElement findElementByLocator(By locator){
        return appiumDriver.findElement(locator);
    }

    public WebElement waitForElementByLocator(By locator, Integer... timeInSeconds){
        webDriverWait = webDriverWaitForTime(timeInSeconds);
        return webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean checkElementIsDisplayed(By locator, Integer... timeInSeconds){
        webDriverWait = webDriverWaitForTime(timeInSeconds);
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }
}
