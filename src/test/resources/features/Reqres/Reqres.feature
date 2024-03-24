Feature: Serenity Rest QE 14
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list user with parameter page <page>
    When Send request get list users
    Then Status code should be 200
    And Response body page should be <page>
    And Validate json schema "ListUsersJsonSchema.json"
    Examples:
      | page |
      | 1    |
      | 2    |

  @Latihan
  Scenario: Post create user with valid json
    Given Create user with valid json "CreateUser.json"
    When Send request create new user
    Then Status code should be 201
    And Response body name should be "morpheus" and job is "leader"
    And Validate json schema "CreateUserJsonSchema.json"

  @Latihan
  Scenario Outline: Update user with user id and valid json
    Given Update user with valid user id <id> and json "<json>"
    When Send request update user
    Then Status code should be 200
    And Response body name should be "<name>" and job is "<job>"
    Examples:
      | id | json             | name              | job                    |
      | 1  | UpdateUser1.json | morpheus update 1 | zion resident update 1 |
      | 2  | UpdateUser2.json | morpheus update 2 | zion resident update 2 |

  @Latihan
  Scenario: Delete user with valid user id
    Given Delete user with valid user id 2
    When Send request delete user
    Then Status code should be 204
