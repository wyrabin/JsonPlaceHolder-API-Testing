Feature: Testing GET comments JsonPlaceHolder

  @GroupProject @Positive-Case
  Scenario Outline: GET comments with valid parameter id
    Given Get comments with valid parameter <id>
    When Send request get list comments
    Then Should return comments with status code 200
    And Response body page should be <id>
    And Validate json schema list comments
    Examples:
      | id |
      | 1  |

  @GroupProject @Negative-Case
  Scenario Outline: GET comments with invalid parameter id
    Given Get comments with valid parameter "<id>"
    When Send request get list comments
    Then Should return comments with status code 404
    And Response body page should be "<id>"
    And Validate json schema list comments
    Examples:
      | id   |
      | abcd |

  @GroupProject @Negative-Case
  Scenario Outline: GET comments with unregistered parameter id
    Given Get comments with valid parameter <id>
    When Send request get list comments
    Then Should return comments with status code 404
    And Response body page should be <id>
    And Validate json schema list comments
    Examples:
      | id  |
      | 501 |

  @GroupProject @Positive-Case
  Scenario: GET comments without parameter
    Given Get comments without any parameter
    When Send request get list comments without param
    Then Should return comments with status code 200
    And Response body page should be page
    And Validate json schema list comments

  @GroupProject @Positive-Case
  Scenario Outline: GET comments with invalid parameter
    Given Get comments with invalid "<parameter>"
    When Send request get list comment invalid param
    Then Should return comments with status code 404
    Examples:
      | parameter |
      | abcde     |