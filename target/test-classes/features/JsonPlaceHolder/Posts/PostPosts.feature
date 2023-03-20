Feature: Testing Post Posts REST API

  @GroupProject @Positive-Case
  Scenario: API POST new posts with valid parameter
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201

  @GroupProject @Negative-Case
  Scenario: API POST new posts with blank parameter
    Given Post create user with invalid json
    When Send request post create user
    Then Should return status code 400

  @GroupProject @Negative-Case
  Scenario:API POST with invalid type data body
    Given Post create user with invalid type data body
    When Send request post create user
    Then Should return status code 400

  @GroupProject @Negative-Case
  Scenario: API POST new posts with extra parameter
    Given Post create user with extra json
    When Send request post create user
    Then Should return status code 400

  @GroupProject @Negative-Case
  Scenario: API POST with less category body
    Given Post create user with less category body
    When Send request post create user
    Then Should return status code 400



