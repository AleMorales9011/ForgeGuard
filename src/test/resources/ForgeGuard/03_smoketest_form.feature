Feature: Form
  As a developer
  I want to be able to extract data from the database
  So I can fill up forms with it

  @form-submission
  Scenario: Form Submission
    Given I am in the form page
    When I extract the information from the database
    When I use the information to fill up the form
    Then I should see the message"Thank you for validating your ticket"