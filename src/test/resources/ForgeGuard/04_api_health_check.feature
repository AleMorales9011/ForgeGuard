Feature: API Tests
  As a tester I want to test the Notes API
  Using the RestAssured Library to make sure I can automate
  this process in the future.

  @api-check
  Scenario: Verify API is running
    When I send a health check request
    Then the response status should be 200

  @api-login
  Scenario: Login
    When I send a login request
    Then the response status must be 200

  @user-info
  Scenario: Get User Info
    When I request user info
    Then the response must be 200
