package com.mobile.automation.steps;
import com.google.inject.Inject;
import com.mobile.automation.contracts.TestGuice;
import io.cucumber.java8.En;

public class TestSteps implements En{
    private TestGuice testGuice;

    @Inject
    public TestSteps(
            TestGuice testGuice
    ) {
        Given("^today is Sunday$", () -> {
            System.out.println("today is Sunday");
            testGuice.printTest();
        });

        When("^I ask whether it's Friday yet$", () -> {
            System.out.println("Is it Friday today?");
        });

        Then("^I should be told \"([^\"]*)\"$", (String arg0) -> {
            System.out.println("I say: " + arg0);
        });
    }
}
