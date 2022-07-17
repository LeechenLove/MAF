package com.mobile.automation.appiumdriver;

import com.google.inject.Inject;
import com.typesafe.config.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * @Author: Lulu
 * @Description: IOS Driver
 * @DateTime: 2022/6/10 18:38
 **/
public class MobileIOSDriver {

    private final Config config;

    @Inject
    public MobileIOSDriver(Config config){
        this.config = config;
    }

    private DesiredCapabilities getCapabilities() {
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone13 Pro");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability(MobileCapabilityType.APP,"/path/to/my.app");
            return capabilities;
        }
        catch (Exception exception) {
            throw new RuntimeException("gen capabilities failed", exception);
        }
    }

    //生成ios driver
    public AppiumDriver iosDriver() {
        try{
            return new IOSDriver(
                    new URL(String.format("http://localhost:%s/wd/hub",
                            config.getString("android.port"))), getCapabilities());
        }
        catch (Exception exception) {
            throw new RuntimeException("failed to build android driver", exception);
        }
    }
}
