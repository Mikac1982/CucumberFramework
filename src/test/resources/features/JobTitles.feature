#Author: syntax team   //john.smith@wellsfargo.com
@jobtitles
Feature: As a User I should see same job title in both UI and Database

  Background: 
    Given I logged in into OrangeHrm
    And I click on Admin link


  @smoke @sprint5
  Scenario Outline: Add Job
    When I click on addJobTitle
    And I enter job "<Title>", "<Description>" and job "<Specification>"
    And I click Save button
    Then I see job "<Title>", "<Description>" and job "<Specification>" is added
    
  @db @regression
  Scenario Outline: Job Title Validation
    And I click on Job link
    When I click on Job Titles
    And I get all Job Titles from UI
    And I execute "<SqlQuery>" from Database
    Then I see results from UI and Database are matched

    Examples:
    |SqlQuery|
    |select job_title from jobs order by 1|