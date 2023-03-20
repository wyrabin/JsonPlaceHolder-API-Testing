Feature: Delete album

  @GroupProject @Positive-Case
  Scenario Outline: Delete users with valid id
  Given Delete albums with valid id <id>
  When Send request delete album
  Then should return status code 200
  Examples:
    | id |
    | 50 |

  @GroupProject @Negativecase
  Scenario Outline: Delete album with invalid id
    Given Delete albums with invalid id <id>
    When Send request delete album
    Then should return status code 404
    Examples:
      | id  |
      | 101 |