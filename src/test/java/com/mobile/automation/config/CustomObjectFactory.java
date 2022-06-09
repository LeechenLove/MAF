package com.mobile.automation.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.mobile.automation.service.impl.TestModule;
import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.ScenarioScope;

/**
 * @Author: Lulu
 * @Description: 用于初始化Guice module
 * @DateTime: 2022/6/9 9:48
 **/
public class CustomObjectFactory implements ObjectFactory {
    private Injector injector;

    public CustomObjectFactory() {
        // Create an injector with our service module
        this.injector =
                Guice.createInjector(
                        Stage.PRODUCTION,
                        CucumberModules.createScenarioModule(),
                        new TestModule());
    }

    @Override
    public boolean addClass( Class< ? > clazz ) {
        return true;
    }

    @Override
    public void start() {
        this.injector.getInstance( ScenarioScope.class ).enterScope();
    }

    @Override
    public void stop() {
        this.injector.getInstance( ScenarioScope.class ).exitScope();
    }

    @Override
    public < T > T getInstance( Class< T > clazz ) {
        return this.injector.getInstance( clazz );
    }
}
