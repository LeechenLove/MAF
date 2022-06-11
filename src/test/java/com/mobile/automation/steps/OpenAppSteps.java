package com.mobile.automation.steps;

import com.google.inject.Inject;
import com.mobile.automation.contracts.OpenApp;
import io.cucumber.java8.En;

/**
 * @Author: Lulu
 * @Description: TODO
 * @DateTime: 2022/6/10 19:22
 **/
public class OpenAppSteps implements En {
    private OpenApp openApp;

    @Inject
    public OpenAppSteps(OpenApp openApp) {
        Given("^open the app$", () -> {
            openApp.startApp();
        });
    }
}
