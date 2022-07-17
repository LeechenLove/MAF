package com.mobile.automation.steps;

import com.google.inject.Inject;
import com.mobile.automation.contracts.Home;
import com.mobile.automation.contracts.OpenApp;
import com.mobile.automation.util.DBConnection;
import io.cucumber.java8.En;
import org.junit.Assert;

import java.sql.Connection;

/**
 * @Author: Lulu
 * @Description: OpenAppSteps
 * @DateTime: 2022/6/10 19:22
 **/
public class OpenAppSteps implements En {

    @Inject
    public OpenAppSteps(OpenApp openApp,
                        Home home,
                        DBConnection dbConnection) {
        Given("^open the app$", () -> {
            openApp.startApp();
        });

        When("^the user can login to the application with valid credentials$", () -> {
            DBConnection.getConn();
            openApp.logonApp(dbConnection.getUserName()[0], dbConnection.getUserName()[1]);
            dbConnection.closeDBConnection();
        });

        Then("^the user navigate to home page$", () -> {
            String failureReason = "home page not appear";
            boolean actual = home.isDisplay();
            boolean expected = true;
            Assert.assertEquals(expected, actual);
        });
    }
}
