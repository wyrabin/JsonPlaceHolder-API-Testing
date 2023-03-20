Feature: Testing GET todos JsonPlaceHolder API

  @GroupProject @Positive-Case
  Scenario Outline: GET todos with modified id should succes then return 200 response code
    Given Get todos with id <id>
    When Send request get list todos with selected id
    Then Should return status code 200 ok
    And Response body id should be <id>
    And Validate json schema list todos
    Examples:
      | id |
      | 90 |

  @GroupProject @Positive-Case
  Scenario: GET todos with id 1 and get respon body page with id 1 should succes then return 200 response code
    Given Get todos with id 1
    When Send request get list todos with selected id
    Then Should return status code 200 ok
    And Response body id should be 1
    And Validate json schema list todos

  @GroupProject @Negative-Case
  Scenario Outline: GET todos with modified id out of range should failed then return 404 response code
    Given Get todos with id <id>
    When Send request get list todos with selected id out of range
    Then Should return status code 404 Not Found
    And Validate json schema lists todos
    Examples:
      | id   |
      | 2000 |

  @GroupProject @Negative-Case
  Scenario Outline: Get todos with invalid parameter id as string should failed then return 400 response code
    Given Get todos with invalid parameter id "<id>" as string
    When Send request get list todos with selected id
    Then Should return status code 400 Bad Request
    And Validate json schema list todos
    Examples:
      | id        |
      | 1adsf1341 |

  @GroupProject @Positive-Case
  Scenario: GET todos without id should success then return 200 response code
    Given Get todos without id
    When Send request get list todos without id
    Then Should return status code 200 ok
    And Response body id should be 1
    And Validate json schema list todos

  @GroupProject @Positive-Case
  Scenario Outline: GET todos with modified parameter should succes then return 200 response code
    Given Get todos with id <id> and modified parameter "<title>"
    When Send request get todos with selected id and parameter
    Then Should return status code 200 ok
    And Response body id should be <id> and response body title should be "<title>"
    And Validate json schema list todos
    Examples:
      | id | title              |
      | 1  | delectus aut autem |

  @GroupProject @Negative-Case
  Scenario Outline: Get todos with invalid id as string should failed then return 404 response code
    Given Get todos with invalid id "<id>"
    When Send request get todos with selected id
    Then Should return status code 404 Not Found
    And Validate json schema lists todos
    Examples:
      | id        |
      | 1adsf1341 |