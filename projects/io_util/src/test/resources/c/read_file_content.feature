Feature: Return the content of a file
    We should be able to return the content of a file to the user

    Scenario Outline: we can read a valid file and return the content
        Given a valid file "<fileName>"
        When we ask for content
        Then we should have the "<expectedContent>" returned

        Examples:
            |   fileName    |   expectedContent |
            |   file1   |   file1   |
            |   file2   |   file2   |

