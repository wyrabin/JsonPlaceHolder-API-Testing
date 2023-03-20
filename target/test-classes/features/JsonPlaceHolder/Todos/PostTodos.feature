Feature: Testing POST Todos JsonPlaceHolder API

  @GroupProject @Positive-Case
  Scenario Outline: POST todos with valid input body should succes then return 201 response code
    Given Post create todos with valid json
    When Send request post todos with valid json
    Then Should return status code 201 Created
    And Response body id should be <id> and title should be "<title>"
    And Validate json schema lists todos
    Examples:
      | id  | title              |
      | 201 | Group Project QE 8 |

  @GroupProject @Negative-Case
  Scenario Outline: POST Todos with blank parameter should failed then return 400 response code
    Given Post create todos with blank parameter json
    When Send request post todos with blank parameter json
    Then Should return status code 400 Bad Request
    And Response body id should be <id> and title should be "<title>"
    And Validate json schema lists todos
    Examples:
      | id | title |
      |    |       |

  @GroupProject @Negative-Case
  Scenario: POST Todos with extra body category should failed then return 400 response code
    Given Post create todos with extra body category json
    When Send request post todos with extra body category json
    Then Should return status code 400 Bad Request
    And Validate json schema lists todos

  @GroupProject @Negative-Case
  Scenario: POST Todos with invalid body data type should failed then return 400 response code
    Given Post create todos with invalid body data type  json
    When Send request post todos with invalid body data type json
    Then Should return status code 400 Bad Request
    And Validate json schema lists todos

  @GroupProject @Negative-Case
  Scenario: POST Todos with invalid body category should failed then return 400 response code
    Given Post create todos with invalid body category json
    When Send request post todos with invalid body category json
    Then Should return status code 400 Bad Request
    And Validate json schema lists todos