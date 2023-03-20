Feature: Testing Get Posts REST API

  @GroupProject @Positive-Case
  Scenario: API GET without id
    Given Get list user
    When Send request get list user without id
    Then Should return status code 200

  @GroupProject @Positive-Case
  Scenario Outline: API GET with valid id
    Given Get list user with <id>
    When Send request get list user
    Then Should return status code 200
    Examples:
      | id |
      | 1  |

  @GroupProject @Positive-Case
  Scenario Outline: API GET with invalid id
    Given Get list user with invalid "<id>"
    When Send request get list user
    Then Should return status code 404
    Examples:
      | id  |
      | abc |

  @GroupProject @Negative-Case
    Scenario: API GET with invalid parameter id
      Given Get list user with invalid parameter id
      When Send request with invalid parameter id
      Then Should return status code 404







