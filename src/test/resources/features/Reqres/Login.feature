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
    Given Post Login with invalid json "LoginInvalid1.json"
    When Send request Post Login User
    Then Status code should be 400

  #Login Scenario 3
  @Tugas
  Scenario Outline: Login with empty value
    Given Post Login with invalid json "<json>"
    When Send request Post Login User
    Then Status code should be 400
    And Response body should be "<error>"
    Examples:
      |                          | json               | error                     |
      | Empty Email              | LoginInvalid2.json | Missing email or username |
      | Empty Password           | LoginInvalid3.json | Missing password          |
      | Empty email and password | LoginInvalid6.json | Missing email or username |

  #Login Scenario 4
  @Tugas
  Scenario Outline: Login without email or password field
    Given Post Login with invalid json "<json>"
    When Send request Post Login User
    Then Status code should be 400
    And Response body should be "<error>"
    Examples:
      |                        | json               | error                     |
      | Missing Email Field    | LoginInvalid4.json | Missing email or username |
      | Missing Password Field | LoginInvalid5.json | Missing password          |

