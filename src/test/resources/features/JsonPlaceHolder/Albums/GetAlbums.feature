Feature: Testing GET

  @GroupProject @Positive-Case
  Scenario: Get album with valid parameter
    Given Get list album with id 1
    When send request get albums
    Then should return status code 200
    And Validate json schema get albums

  @GroupProject @NegativeCase
  Scenario: Get album with invalid parameter
    Given Get list album with invalid id 101
    When send request get albums
    Then should return status code 404




