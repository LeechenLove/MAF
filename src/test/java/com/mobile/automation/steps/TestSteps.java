package com.mobile.automation.steps;
import io.cucumber.java8.En;

public class TestSteps implements En{
    public TestSteps() {
        Given("^today is Sunday$", () -> {
            System.out.println("today is Sunday");
        });

        When("^I ask whether it's Friday yet$", () -> {
            System.out.println("Is it Friday today?");
        });

        Then("^I should be told \"([^\"]*)\"$", (String arg0) -> {
            System.out.println("I say: " + arg0);
        });
    }
}
