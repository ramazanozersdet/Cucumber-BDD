@AddEmployee
Feature:  Add Employee

  @smoke
  Background:
    When login with valid credentials
    Then navigate to add employee page

  @smoke
  Scenario: Add employee without login details
    And enter first and last name
    Then click on save Button
    And verify the employee is added succesfully

  @smoke
  Scenario: Add employee with login credentials
    And enter first and last name
    When check login details checkbox
    Then enter login details
    Then click on save Button
    And verify the employee is added succesfully

  @parameter @smoke
  Scenario: Add employee without login details but with middle name
    When User enter first name as "John" middle name as "Charlie" and last name as a "Wick"
    Then click on save Button
    And verify that "John Charlie Wick"  is added succesfully

  @examples @smoke
  Scenario Outline: Adding Multiple employees without login details
    When enter employee "<First Name>", "<Middle Name>" and "<Last Name>"
    Then click on save Button
    And verify that "<First Name>", "<Middle Name>" and "<Last Name>" is successfully added
    Examples:
      | First Name | Middle Name | Last Name |
      | Mark       | J           | Smith     |
      | Hunder     | D           | Museov    |
      | John       | M           | Wick      |
      | John       | F           | Kennedy   |

  @dtWithHeader @smoke
  Scenario: Adding multiple employees at one execution
    When add multiple employess and verify they are added
      | First Name | Middle Name | Last Name |
      | Mark       | J           | Smith     |
      | Hunder     | D           | Museov    |
      | John       | M           | Wick      |
      | John       | F           | Kennedy   |


    @exceltask @smoke
    Scenario: Adding multiple employees from excel file
      When add multiple employees from "AddEmployee" verify they are added successfully


