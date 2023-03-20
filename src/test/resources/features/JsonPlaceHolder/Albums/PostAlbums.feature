Feature: Testing Create Album

  @GroupProject @Positive-Case
  Scenario: Post create album with valid json
    Given Post create albums with valid json
    When Send request post create albums
    Then should return status code 201

  @GroupProject @Negative-Case
  Scenario: Post create album with invalid json
    Given Post create albums with invalid json
    When Send request post create albums
    Then should return status code 404

  @GroupProject @Negative-Case
  Scenario: Post create album with same body json
    Given Post create albums with same body json
    When Send request post create albums
    Then should return status code 404

  @GroupProject @Negative-Case
  Scenario: Post create album with blank body json
    Given Post create albums with blank body json
    When Send request post create albums
    Then should return status code 404

  @GroupProject @Negative-Case
  Scenario: Post create album with extra body json
    Given Post create albums with extra parameter body json
    When Send request post create albums
    Then should return status code 404



