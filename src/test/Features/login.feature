#@smoke scenario
Feature: To test login page
  @smoketest
  Scenario: check able to login succesful "admin" and "testleaf"
    Given  user is on the login page
    When  user enters the username and password
    And click login button
    Then user should navigate to home page

