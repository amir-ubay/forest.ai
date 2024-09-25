@career
Feature: Careers functionality

  Scenario: Verify job page title software engineer
    Given User opens careers page
    When User clicks job card software engineer
    Then User sees correct job page title software engineer

  Scenario:  Verify job page title qa engineer
    Given User opens careers page
    When User clicks job card qa engineer
    Then User sees correct job page title qa engineer

  Scenario:  Verify job page title qa engineer
    Given User opens careers page
    When User clicks job card unity developer
    Then User sees correct job page title unity developer