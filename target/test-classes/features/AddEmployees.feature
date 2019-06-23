#Author syntax team    //john.smith@wellsfargo.com
@addEmplyee @sprint5
Feature: Add Employee

  Background: 
    Given I logged in into OrangeHrm
    And I click on PIM link
    And I click on AddEmployee link

  @smoke @addEmployee
  Scenario Outline: Add Employee
    When I provide "<FirstName>", "<MiddleName>", "<LastName>" and "<Location>"
    And I click on save button
    Then I see "<FirstName>", "<LastName>" is displayed

    Examples: 
      | FirstName | MiddleName | LastName | Location |
      | Jane      | J          | Smith    | Ben      |
      | James     | S          | West     | Dani     |
      | Jackie    | N          | East     | Ben      |

  @regression
  Scenario Outline: Add Employee and Create Login Details
    When I provide "<FirstName>", "<MiddleName>", "<LastName>" and "<Location>"
    And I click on create login details
    And I provide all mandatory fields "<UserName>", "<Password>" , "<ConfirmPassword>", "<ESSRole>" and "<SuperRole>"
    And I click on save button
    Then I see employee "<FirstName>", "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName | Location | UserName | Password      | ConfirmPassword | ESSRole    | SuperRole         |
      | Alex      | A          | Spirs    | Ben      | Cucumber | Cucumber125!@ | Cucumber125!@   | DefaultESS | DefaultSupervisor |

  @regression  @temp
  Scenario: Add Employee Labels Verification
    Then I see following labels
      | First Namessss       |
      | Middle Name          |
      | Last Name            |
      | Employee Id          |
      | Location             |
      | Create Login Details |
