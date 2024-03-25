Feature: Register User

  #Register Scenario 1
  @Tugas
  Scenario: Register user with valid json
    Given Post Register user with valid json "RegisterUser.json"
    When Send request Post Register User
    Then Status code should be 200
    And Validate json schema "RegisterUserJsonSchema.json"

  #Register Scenario 2
  @Tugas
  Scenario Outline: Register user with invalid json
    Given Post Register user with invalid json "<json>"
    When Send request Post Register User
    Then Status code should be 400
    And Response body should be "<error>"
    Examples:
      | json                      | error                     |
      | RegisterUserInvalid1.json | Missing email or username |
      | RegisterUserInvalid2.json | Missing password          |

  #Register Scenario 3
  @Tugas
  Scenario: Register user with invalid email format
    Given Post Register user with invalid email format "RegisterUserInvalid3.json"
    When Send request Post Register User
    Then Status code should be 400
    And Response body should be "Note: Only defined users succeed registration"



