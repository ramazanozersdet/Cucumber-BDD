@login
Feature: Login Functionally

  @smoke @cigar
  Scenario: Login with valid credentials
    When login with valid credentials
    Then verify the dashboard logo is displayed

  @regression @cigar
  Scenario: Login with invalid credentials
    When login with invalid credentials
    Then verify the error message

  @smoke
  Scenario: Login with empty username
    When login with empty username
    Then verify the error message "Username cannot be empty"

  @smoke
  Scenario: Login with empty password
    When login with empty password
    Then verify the error message "Password cannot be empty"