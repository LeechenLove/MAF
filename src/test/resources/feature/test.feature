@test1
Feature: Mobile Automation Test
  This feature is only for MAF framework testing

  Scenario: Sunday isn't Friday
    Given today is Sunday
    When I ask whether it's Friday yet
    Then I should be told "Nope"