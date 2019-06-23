#Autor: syntax team     or  john.smith@wellsfargo.com
@sprint3
Feature: Login

  #Description: This feature file contains all the information about the lasjdflkdjfsjd
  Background: 
    Given I see OrangeHrm logo

  @login
  Scenario: Valid Login
    When I enter valid username and password
    And I click login button
    Then I successfully  logged in

  @regression @login
  Scenario: Invalid login
    When I enter invalid username and password
    And I click login button
    Then I see error message is displayed!

@error
  Scenario: Error message Validation
    When I enter invalid username and password I see errorMessage
      | UserName | Password   | errorMessage        |
      | Admin    | Admin1234  | Invalid Credentials |
      | Admin1   | Syntax123! | errorMessage        |
