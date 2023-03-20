Feature: Testing PUT comments JsonPlaceHolder

  @GroupProject @Positive-Case
  Scenario Outline: PUT comments with valid json
    Given Put comments with valid json with id 1
    When Send request put comments
    Then Should return status code 200
    And Response body page should be <postId>,"<name>","<email>" and "<body>"
    And Validate json schema post comments
    Examples:
      | postId | name |  | email             | body         |
      | 1      | aku  |  | emailku@gmail.com | hanya ngetes |

  @GroupProject @Negative-Case
  Scenario Outline: PUT comments with invalid json
    Given Put comments with invalid json with id 1
    When Send request put comments
    Then Should return status code 400
    And Response body page should be <postId>,"<name>","<email>" and "<body>"
    And Validate json schema post comments
    Examples:
      | postId | name |  | email             | body         |
      | 1      | aku  |  | emailku@gmail.com | hanya ngetes |

  @GroupProject @Negative-Case
  Scenario Outline: Put comments with unrequired object at json
    Given Put comments with unrequired object at json with id 1
    When Send request put comments
    Then Should return status code 400
    And Response body page should be <postId>,"<name>","<email>" and "<number>"
    And Validate json schema post comments
    Examples:
      | postId | name |  | email             | number     |
      | 1      | aku  |  | emailku@gmail.com | 0812345678 |

  @GroupProject @Negative-Case
  Scenario Outline: Put comments with invalid parameter id
    Given Put comments with valid parameter id 503
    When Send request put comments with param
    Then Should return status code 400
    And Response body page should be <postId>,"<name>","<email>" and "<body>"
    And Validate json schema post comments
    Examples:
      | postId | name |  | email             | body         |
      | 1      | aku  |  | emailku@gmail.com | hanya ngetes |

  @GroupProject @Negative-Case
  Scenario: Put comments with blank json
    Given Post comments with blank json with id 1
    When Send request put comments
    Then Should return status code 400