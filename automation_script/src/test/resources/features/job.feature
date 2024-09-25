@job_application
Feature: Job Application

#  Scenario: Verify success fill personal data
    Given User opens qa engineer job
    When User apply the job
    When User fills personal data
    Then User sees upload cv form

  Scenario: Verify success upload cv
    Given User opens qa engineer job
    When User apply the job
    When User fills personal data
    When User uploads valid cv
    Then User sees complete info


  Scenario: Verify success upload cv by drag and drop
    Given User opens qa engineer job
    When User apply the job
    When User fills personal data
    When User drag and drop valid cv
    Then User sees complete info

  Scenario: Verify success info after job application
    Given User opens qa engineer job
    When User apply the job
    When User fills personal data
    When User uploads cv
    When User sets cover letter
    When User submit job application
    Then User sees success submit info

  Scenario: Verify validation for empty name
    Given User opens qa engineer job
    When User apply the job
    When User fills empty name
    Then User sees empty name validation

  Scenario: Verify validation for empty email
    Given User opens qa engineer job
    When User apply the job
    When User fills empty email
    Then User sees empty email validation

  Scenario: Verify validation for empty code
    Given User opens qa engineer job
    When User apply the job
    When User fills empty code
    Then User sees empty code validation

  Scenario: Verify validation for empty phone number
    Given User opens qa engineer job
    When User apply the job
    When User fills empty phone
    Then User sees empty phone validation

  Scenario: Verify validation for not upload cv
    Given User opens qa engineer job
    When User apply the job
    When User fills personal data
    When User does not upload cv
    Then User sees error info not upload cv