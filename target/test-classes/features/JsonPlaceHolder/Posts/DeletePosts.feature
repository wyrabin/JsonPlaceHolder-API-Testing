Feature: Testing Delete Posts REST API

  @GroupProject @Positive-Case
  Scenario Outline: API DELETE posts with valid parameter
    Given Delete posts with valid id <id>
    When Send post request to delete user
    Then Should return status code 204
    Examples:
      | id |
      | 1  |

  @GroupProject @Negative-Case
  Scenario Outline: API DELETE posts with invalid parameter
    Given Delete user with invalid <id>
    When Send post request to delete user
    Then Should return status code 404
    Examples:
      | id   |
      | 8491 |
