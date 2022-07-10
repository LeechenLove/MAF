@test
Feature: Open Api Demo app

  Scenario: the user open the api demo app
    Given open the app
    When the user can login to the application with valid credentials
    Then the user navigate to home page