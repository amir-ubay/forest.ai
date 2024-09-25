@home
Feature: Home functionality

  Scenario: Verify homepage title
    Given User opens homepage
    Then User sees correct homepage title


  Scenario: Verify navigation to career page
    Given User opens homepage
    When User clicks career link
    Then User sees correct careers page title