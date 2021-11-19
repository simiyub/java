Feature: Delete file
  We should be able to delete a file given the file path

  Scenario: we can delete a file given a valid file path
    Given a valid "file" path
    When requested to delete
    Then delete the file

