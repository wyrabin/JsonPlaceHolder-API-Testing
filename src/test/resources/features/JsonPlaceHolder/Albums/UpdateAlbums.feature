Feature: Put update albums

  @GroupProject @Positive-Case
  Scenario:Put update album with valid parameter
    Given Put update album with valid json with id 1
    When Send request put update album
    Then should return status code 200
    And Response body id user should be 1 and id 1 and title should be "quidem molestiae enim"

  @GroupProject @Negative-Case
  Scenario:Put update album with invalid parameter request
    Given Put update album with invalid json with id 1
    When Send request put update album
    Then should return status code 400

  @GroupProject @Negative-Case
  Scenario:Put update album with blank body
    Given Put update album with blank json with id 1
    When Send request put update album
    Then should return status code 400

  @GroupProject @Negative-Case
  Scenario:Put update album with extra body json
    Given Put update album with extra body json with id 1
    When Send request put update album
    Then should return status code 400

  @GroupProject @Positive-Case
  Scenario Outline:Put update album with unregister body json
    Given Put update album with unregister id <id>
    When Send request put update album
    Then should return status code 500
    Examples:
      | id  |
      | 202 |
