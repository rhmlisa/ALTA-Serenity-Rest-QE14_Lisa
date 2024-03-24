Feature: Update User

  #Update User Scenario 1
  @Tugas
  Scenario Outline: Update user with user id and valid json
    Given Update user with valid user id <id> and json "<json>"
    When Send request update user
    Then Status code should be 200
    And Response body name should be "<name>" and job is "<job>"
    And Validate json schema "UpdateUserJsonSchema.json"
    Examples:
      | id | json             | name              | job                    |
      | 1  | UpdateUser1.json | morpheus update 1 | zion resident update 1 |
      | 2  | UpdateUser2.json | morpheus update 2 | zion resident update 2 |

  #Update User Scenario 2
  @Tugas
  Scenario Outline: Update user with non-existing user id and valid json
    Given Update user with non-existing user id <id> and valid json "<json>"
    When Send request update user
    Then Status code should be 404
    Examples:
      | id  | json             |
      | 999 | UpdateUser1.json |
      | -24 | UpdateUser2.json |

  #Update User Scenario 3
  @Tugas
  Scenario: Update User with valid user id without name on json
   Given Update user with user id 1 without name on json "UpdateUserInvalid1.json"
   When Send request update user
   Then Status code should be 400

  #Update User Scenario 4
  @Tugas
  Scenario: Update User with valid user id without job on json
    Given Update user with user id 1 without name on json "UpdateUserInvalid2.json"
    When Send request update user
    Then Status code should be 400