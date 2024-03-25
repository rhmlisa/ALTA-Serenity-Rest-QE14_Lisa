Feature: Login User

  #Login Scenario 1
  @Tugas
  Scenario: Login with valid json
    Given Post Login with valid json "Login.json"
    When Send request Post Login User
    Then Status code should be 200
    And Validate json schema "LoginJsonSchema.json"

  #Login Scenario 2
  @Tugas
  Scenario: Login with unregistered email
    Given Post Login with unregistered email on json "LoginInvalid1.json"
    When Send request Post Login User
    Then Status code should be 400

  #Login Scenario 3
  @Tugas
  Scenario Outline: Login with invalid json
    Given Post Login with invalid json "<json>"
    When Send request Post Login User
    Then Status code should be 400
    And Response body should be "<error>"
    Examples:
      | json               | error                     |
      | LoginInvalid2.json | Missing email or username |
      | LoginInvalid3.json | Missing password          |


