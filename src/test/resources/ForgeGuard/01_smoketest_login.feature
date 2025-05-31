Feature: Login Functionality
  As a developer
  I want to be able to test the login with valid / invalid credentials
  So that I can ensure the functionality works properly

  @valid-login
  Scenario: Valid Login
    Given I am in the login page
    When I enter the valid credentials "practice" and "SuperSecretPassword!"
    Then I should be redirected to the secure page
    And I should see a welcome message "Secure Area page for Automation Testing Practice"

  @invalid-login
  Scenario: Invalid Login
    Given I am in the login page
    When I enter the invalid credentials "2" and "2"
    Then I should see an error message "Your username is invalid!"

  @special-character
  Scenario: Special Character
    Given I am in the login page
    When I enter the special character"<"and"@"
    Then I should see an error"Your username is invalid!"

  @database-driven-login
  Scenario: Database Valid Login
    Given I am in the login page
    When  I query the database for the credentials
    Then  I should use those credentials to log in
    And   I should see a message"Secure Area page for Automation Testing Practice"
