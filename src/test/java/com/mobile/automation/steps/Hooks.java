package com.mobile.automation.steps;

/**
 * @Author: Lulu
 * @Description: TODO
 * @DateTime: 2022/7/11 22:11
 **/
import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;


/**
 * @Author: Lulu
 * @Description: Cucumber Hook
 * @DateTime: 2022/7/11 21:57
 **/
public class Hooks {

    private final AppiumDriver appiumDriver;

    @Inject
    public Hooks(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

//    @Before
//    public void beforeAllScenario(){
//        System.out.println("Run this method before all scenario");
//    }
//
    @After
    public void closeAppiumDriver(){
        Runtime.getRuntime().addShutdownHook(new Thread(appiumDriver::quit));
    }

}
