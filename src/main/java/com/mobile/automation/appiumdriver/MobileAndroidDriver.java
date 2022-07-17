package com.mobile.automation.appiumdriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * @Author: Lulu
 * @Description: Android Driver
 * @DateTime: 2022/6/10 8:42
 **/
public class MobileAndroidDriver {

    private DesiredCapabilities getCapabilities(){
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PDNM00");
            capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+ "\\testapp\\loginApp.apk");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");
            capabilities.setCapability("appPackage", "com.maxsoftlk.loginapplication");
            capabilities.setCapability("appActivity", "com.maxsoftlk.loginapplication.MainActivity");
            return capabilities;
        }
        catch (Exception exception) {
            throw new RuntimeException("Gen capabilities fail...", exception);
        }
    } //getCapabilities end

    //生成android driver
    public AppiumDriver androidDriver(){
        try{
            return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), getCapabilities());
        }
        catch (Exception exception) {
            throw new RuntimeException("failed to build android driver", exception);
        }
    } //androidDriver end
}
