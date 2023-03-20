Feature: Testing POST comments JsonPlaceHolder

  @GroupProject @Positive-Case
  Scenario Outline: POST comments with valid json
    Given Post comments with valid json
    When Send request post comments
    Then Should return status code 201
    And Response body page should be <postId>,"<name>","<email>" and "<body>"
    And Validate json schema post comments
    Examples:
      | postId | name |  | email             | body         |
      | 1      | aku  |  | emailku@gmail.com | hanya ngetes |

  @GroupProject @Negative-Case
  Scenario Outline: POST comments with invalid json
    Given Post comments with invalid json
    When Send request post comments
    Then Should return status code 400
    And Response body page should be <postId>,"<name>","<email>" and "<body>"
    And Validate json schema post comments
    Examples:
      | postId | name |  | email             | body         |
      | 1      | aku  |  | emailku@gmail.com | hanya ngetes |

  @GroupProject @Negative-Case
  Scenario Outline: POST comments with unrequired object at json
    Given Post comments with unrequired object at json
    When Send request post comments
    Then Should return status code 400
    And Response body page should be <postId>,"<name>","<email>" and "<number>"
    And Validate json schema post comments
    Examples:
      | postId | name |  | email             | number     |
      | 1      | aku  |  | emailku@gmail.com | 0812345678 |

  @GroupProject @Negative-Case
  Scenario Outline: POST comments with valid parameter id
    Given Post comments with valid parameter id 1
    When Send request post comments with param
    Then Should return status code 400
    And Response body page should be <postId>,"<name>","<email>" and "<body>"
    And Validate json schema post comments
    Examples:
      | postId | name |  | email             | body         |
      | 1      | aku  |  | emailku@gmail.com | hanya ngetes |

  @GroupProject @Negative-Case
  Scenario: POST comments with blank json
    Given Post comments with blank json
    When Send request post comments
    Then Should return status code 400
