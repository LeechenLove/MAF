package com.mobile.automation.service.impl;

import com.google.inject.AbstractModule;
import com.mobile.automation.appiumdriver.AppiumDriverProvider;
import com.mobile.automation.contracts.OpenApp;
import com.mobile.automation.contracts.TestGuice;
import com.mobile.automation.page.OpenAppPage;
import com.mobile.automation.page.TestGuiceImpl;
import io.appium.java_client.AppiumDriver;

/**
 * @Author: Lulu
 * @Description: Binding Module
 * @DateTime: 2022/6/9 9:53
 **/
public class TestModule extends AbstractModule {

    @Override
    protected void configure(){
        bind(TestGuice.class).to(TestGuiceImpl.class);
        bind(AppiumDriver.class).toProvider(AppiumDriverProvider.class);
        bind(OpenApp.class).to(OpenAppPage.class);
    } //configure end
}
