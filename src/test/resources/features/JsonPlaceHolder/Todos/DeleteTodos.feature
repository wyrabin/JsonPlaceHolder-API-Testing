Feature: Testing Delete Todos JsonPlaceHolder API

  @GroupProject @Positive-Case
  Scenario Outline: Delete todos with valid id should success then return 200 response code
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 200 ok
    Examples:
      | id |
      | 1  |

  @GroupProject @Negative-Case
  Scenario Outline: Delete todos with valid id but out of range should failed then return 404 response code
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 404 Not Found
    Examples:
      | id   |
      | 8888 |

  @GroupProject @Negative-Case
  Scenario Outline: DELETE todos with invalid id should failed then return 400 response code
    Given Delete user with invalid id "<id>"
    When Send request delete user
    Then Should return status code 400 Bad Request
    Examples:
      | id      |
      | 4=?gas3 |