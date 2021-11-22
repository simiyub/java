Feature: Return the content of a file
  We should be able to return the content of a file to the user

  Scenario: we can read a valid file and return the content
    Given a valid "file" with "content" to read
    When we ask for content
    Then we should have "content" returned

