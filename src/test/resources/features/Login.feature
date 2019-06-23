#Autor: syntax team     or  john.smith@wellsfargo.com
@sprint3 @login
Feature: Login

  #Description: This feature file contains all the information about the lasjdflkdjfsjd
  Background: 
    Given I see OrangeHrm logo

  @smoke @test
  Scenario: Valid Login
    When I enter valid username and password
    And I click login button
    Then I successfully  logged in

  @regression 
  Scenario: Invalid login
    When I enter invalid username and password
    And I click login button
    Then I see error message is displayed!

  @regression
  Scenario: Error message Validation
    When I enter invalid username and password I see errorMessage
      | UserName | Password   | ErrorMessage         |
      | Admin    | Admin1234  | Invalid Credentials  |
      | Admin1   | Syntax123! | Invalid Credentials  |
      | Admin2   | Syntax123  | Invalid Credentials  |
