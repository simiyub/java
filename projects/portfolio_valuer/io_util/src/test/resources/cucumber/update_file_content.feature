Feature: Update file content
  We should be able to update a given file with content provided

  Scenario: a valid file should be updated with the contents provided
    Given a valid "fileName" to update
    When provided with "content" to add
    Then the content should be appended to the file

