package com.mobile.automation.steps;

import com.google.inject.Inject;
import com.mobile.automation.contracts.Home;
import com.mobile.automation.contracts.OpenApp;
import io.cucumber.java8.En;
import org.junit.Assert;

/**
 * @Author: Lulu
 * @Description: TODO
 * @DateTime: 2022/6/10 19:22
 **/
public class OpenAppSteps implements En {

    @Inject
    public OpenAppSteps(OpenApp openApp,
                        Home home) {
        Given("^open the app$", () -> {
            openApp.startApp();
        });

        When("^the user can login to the application with valid credentials$", () -> {
            openApp.logonApp("Osanda", "MaxSoft123");
        });

        Then("^the user navigate to home page$", () -> {
            String failureReason = "home page not appear";
            boolean actual = home.isDisplay();
            boolean expected = true;
            Assert.assertEquals(expected, actual);
        });
    }
}
