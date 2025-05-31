Feature: H2 Database Testing
  As a developer
  I want to test the H2 database connection
  So that I can verify that the database operations work as expected

@database-validation
  Scenario: Validate H2 database connection and query
    Given a sample H2 database is initialized
    When a user with ID 1 is queried
    Then the user name should be "John Doe"
