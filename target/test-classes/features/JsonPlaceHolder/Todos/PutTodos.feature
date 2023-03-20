Feature: Testing PUT Todos JsonPlaceHolder API

  @GroupProject @Positive-Case
  Scenario Outline:Put update user with valid json should success then return 200 response code
    Given Put update todos with valid json body and id <id>
    When Send request put update todos
    Then Should return status code 200 ok
    And Validate json schema lists todos
    Examples:
      | id |
      | 1  |

  @GroupProject @Negative-Case
  Scenario Outline: Put update user with difference userID and id should failed then return 400 response code
    Given Put update todos with difference userID and id <id>
    When Send request put update todos with difference userID and id
    Then Should return status code 400 Bad Request
    And Validate json schema lists todos
    Examples:
      | id |
      | 1  |

  @GroupProject @Negative-Case
  Scenario Outline: Put update user with blank body should failed then return 400 response code
    Given Put update todos with blank body and with id <id>
    When Send request put update todos with blank body
    Then Should return status code 400 Bad Request
    And Validate json schema lists todos
    Examples:
      | id |
      | 1  |

  @GroupProject @Negative-Case
  Scenario Outline: Put update user with extra body category should failed then return 400 response code
    Given Put update todos with extra body category and with id <id>
    When Send request put update todos with extra body category
    Then Should return status code 400 Bad Request
    And Validate json schema lists todos
    Examples:
      | id |
      | 1  |

  @GroupProject @Negative-Case
  Scenario Outline: Put update user with invalid body data type should failed then return 400 response code
    Given Put update todos with invalid body data type and with id <id>
    When Send request put update todos with invalid body data type
    Then Should return status code 400 Bad Request
    And Validate json schema lists todos
    Examples:
      | id |
      | 1  |

  @GroupProject @Negative-Case
  Scenario Outline: Put update user with invalid body category should failed then return 400 response code
    Given Put update todos with invalid body category and with id <id>
    When  Send request put update todos with invalid body category
    Then Should return status code 400 Bad Request
    And Validate json schema lists todos
    Examples:
      | id |
      | 1  |

#  @GroupProject @Negative-Case
#  Scenario Outline: Put update user without id should failed then return 500 response code
#    Given Put update todos without id <id>
#    When Send request put update todos without id
#    Then Should return status code 500 Internal Server Error
#    And Validate json schema lists todos
#    Examples:
#      | id |
#      | 1  |

  @GroupProject @Negative-Case
  Scenario Outline: Put update user with unregistered id should failed then return 500 response code
    Given Put update todos with unregistered id <id>
    When  Send request put update todos with unregistered id
    Then Should return status code 500 Internal Server Error
    Examples:
      | id   |
      | 1999 |

  @GroupProject @Negative-Case
  Scenario Outline: Put update user with invalid id as string should failed then return 500 response code
    Given Put update todos with invalid id "<id>" as string
    When  Send request put update todos with invalid id as string
    Then Should return status code 500 Internal Server Error
    Examples:
      | id    |
      | ASD12 |