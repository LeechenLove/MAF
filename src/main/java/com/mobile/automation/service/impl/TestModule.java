package com.mobile.automation.service.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mobile.automation.appiumdriver.AppiumDriverProvider;
import com.mobile.automation.contracts.Home;
import com.mobile.automation.contracts.OpenApp;
import com.mobile.automation.contracts.TestGuice;
import com.mobile.automation.page.HomePage;
import com.mobile.automation.page.OpenAppPage;
import com.mobile.automation.page.TestGuiceImpl;
import com.mobile.automation.practice.A;
import com.mobile.automation.practice.AImpl;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Lulu
 * @Description: Binding Module
 * @DateTime: 2022/6/9 9:53
 **/
public class TestModule extends AbstractModule {

    private static final Logger log = LoggerFactory.getLogger(TestModule.class);

    @Override
    protected void configure(){
        bind(TestGuice.class).to(TestGuiceImpl.class);
        bind(AppiumDriver.class).toProvider(AppiumDriverProvider.class);
        bind(OpenApp.class).to(OpenAppPage.class);
        bind(Home.class).to(HomePage.class);
        bind(A.class).to(AImpl.class);
    } //configure end

    @Provides
    @Singleton
    public Config configProvider(){
        Config config = null;
        try{
            Config applicationConf = ConfigFactory.parseResources("application.conf");
            config = ConfigFactory.systemEnvironment()
                    .withFallback(applicationConf)
                    .resolve();
        }catch (Exception e){
            log.error("parse application conf failure", e);
        }
        return config;
    }
}