package com.mobile.automation.steps;

/**
 * @Author: Lulu
 * @Description: TODO
 * @DateTime: 2022/7/11 22:11
 **/
import com.google.inject.Inject;
import com.mobile.automation.util.DBConnection;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;


/**
 * @Author: Lulu
 * @Description: Cucumber Hook
 * @DateTime: 2022/7/11 21:57
 **/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    private final AppiumDriver appiumDriver;

    @Inject
    public Hooks(AppiumDriver appiumDriver,
                 DBConnection dbConnection){
        this.appiumDriver = appiumDriver;
    }

//    @Before
//    public void beforeAllScenario(){
//        System.out.println("Run this method before all scenario");
//    }
//
//    @After
//    public void closeAppiumDriver(){
//        Runtime.getRuntime().addShutdownHook(new Thread(appiumDriver::quit));
//    }

    @After
    public void screenShot(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            String testName = scenario.getName();
            Allure.addAttachment(testName, new ByteArrayInputStream(((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.BYTES)));
        }
    }
}
