Feature: Get List Resources
  @Tugas
  Scenario: Get List Resources with valid parameter id
    Given Get all list resources with valid parameter id
    When Send request get list resources
    Then Status code should be 200
    And Response body page should 1 and per page should 6
    And Validate json schema "ListResourceJsonSchema.json"

  @Tugas
  Scenario Outline: Get single Resources with valid data id
    Given Get single resources with valid id <id>
    When Send request get single resources
    Then Status code should be 200
    And Response body id should <id> and name should "<name>"
    And Validate json schema "SingleResourceJsonSchema.json"
    Examples:
      | id | name         |
      | 2  | fuchsia rose |
      | 3  | true red     |

  @Tugas
  Scenario Outline: Get single Resources with invalid data id
    Given Get single resources with invalid id <id>
    When Send request get single resources
    Then Status code should be 404
    Examples:
      | id  |
      | 23  |
      | 999 |