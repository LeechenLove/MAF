package com.mobile.automation.appiumdriver;

import com.google.inject.Provider;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Lulu
 * @Description: Appium Driver Provider
 * @DateTime: 2022/6/10 18:52
 **/
public class AppiumDriverProvider implements Provider<AppiumDriver> {

    private static AppiumDriver sessionDriver;
    private final static Logger log = LoggerFactory.getLogger(AppiumDriverProvider.class);
    private final String platform = System.getProperty("platform");

    @Override
    public AppiumDriver get() {
        if (sessionDriver == null) {
            try {
                if (platform == null || platform.length() == 0) {
                    log.error("Property platform not set, please set to android/ios");
                }
                else if (platform.equalsIgnoreCase("android")) {
                    log.info("Building android driver session");
                    sessionDriver = new MobileAndroidDriver().androidDriver();
                }
                else if (platform.equalsIgnoreCase("ios")) {
                    log.info("Building ios driver session");
                    sessionDriver = new MobileIOSDriver().iosDriver();
                }
                return sessionDriver;
            }
            catch (Exception exception) {
                throw new RuntimeException("Building appium driver fail...", exception);
            }
        }
        return sessionDriver;
    } //AppiumDriver end
}
