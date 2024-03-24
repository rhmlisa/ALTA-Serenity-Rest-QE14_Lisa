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
  Scenario Outline: Register user with empty value
    Given Post Register user with invalid data on json "<json>"
    When Send request Post Register User
    Then Status code should be 400
    And Response body should be "<error>"
    Examples:
      |                          | json                      | error                     |
      | empty email              | RegisterUserInvalid1.json | Missing email or username |
      | empty password           | RegisterUserInvalid2.json | Missing password          |
      | empty email and password | RegisterUserInvalid3.json | Missing email or username |

  #Register Scenario 3
  @Tugas
  Scenario: Register user with invalid email format
    Given Post Register user with invalid data on json "RegisterUserInvalid4.json"
    When Send request Post Register User
    Then Status code should be 400
    And Response body should be "Note: Only defined users succeed registration"

  #Register Scenario 4
  @Tugas
  Scenario Outline: Register user without email or password field
    Given Post Register user with invalid data on json "<json>"
    When Send request Post Register User
    Then Status code should be 400
    And Response body should be "<error>"
    Examples:
      |                        | json                      | error                     |
      | missing email field    | RegisterUserInvalid5.json | Missing email or username |
      | missing password field | RegisterUserInvalid6.json | Missing password          |

