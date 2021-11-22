Feature: Create a file
  Scenario: We can create a file in a location requested file
    Given a valid "file" path name
    When requested to create a file
    Then we create a file in that "name"