package com.mobile.automation.config;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunStarted;
import io.cucumber.plugin.event.TestRunFinished;

/**
 * @Author: Lulu
 * @Description: Cucumber Global Hook
 * @DateTime: 2022/7/12 21:59
 **/
public class CucumberHook implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, event -> {
            System.out.println("Before all");
        });

        publisher.registerHandlerFor(TestRunFinished.class, event -> {
            System.out.println("After all");
        });
    }

}
