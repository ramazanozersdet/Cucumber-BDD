Feature: Dashboard Functionality

  @dash
  Scenario: Dashboard tab verification
    When login with valid credentials
    Then verify the following dashboard tabs
      |Admin|PIM|Leave|Time|Recruitment|My Info|Performance|Dashboard|Directory|Maintenance|Buzz|

