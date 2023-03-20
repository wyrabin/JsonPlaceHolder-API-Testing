Feature: Testing Put Posts REST API

  @GroupProject @Positive-Case
  Scenario Outline: API PUT with valid parameter
    Given Put update user with valid json with <id>
    When Send request put update user
    Then Should return status code <statusCode>
    Examples:
      | id | statusCode |
      | 3  | 200        |

  @GroupProject @Negative-Case
  Scenario Outline: API PUT with blank body
    Given Put update user with invalid json with <id> and blank body json
    When Send request put update user
    Then Should return status code <statusCode>
    Examples:
      | id | statusCode |
      | 3  | 400        |

  @GroupProject @Negative-Case
  Scenario Outline: API PUT with invalid type data body
    Given Put update user with invalid json with <id> and invalid type data body json
    When Send request put update user
    Then Should return status code <statusCode>
    Examples:
      | id | statusCode |
      | 3  | 400        |

  @GroupProject @Negative-Case
  Scenario Outline: API PUT with extra body
    Given Put update user with invalid json with id <id> and extra body json
    When Send request put update user
    Then Should return status code <statusCode>
    Examples:
      | id | statusCode |
      | 3  | 400        |

  @GroupProject @Negative-Case
  Scenario Outline: API PUT with less category body
    Given Put update user with invalid json with id <id> and less category body
    When Send request put update user
    Then Should return status code <statusCode>
    Examples:
      | id | statusCode |
      | 3  | 400        |




