Feature: Delete User

  #Delete User Scenario 1
  @Tugas
  Scenario Outline: Delete user with valid user id
    Given Delete user with valid user id <id>
    When Send request delete user
    Then Status code should be 204
    Examples:
      | id |
      | 4  |
      | 5  |
      | 6  |

  #Delete User Scenario 2
  @Tugas
  Scenario Outline: Delete user with invalid or non-existing user id
    Given Delete user with invalid user id <id>
    When Send request delete user
    Then Status code should be 404
    Examples:
      | id  |
      | -1  |
      | 100 |

  #Delete User Scenario 3
  @Tugas
  Scenario Outline: Delete user with non-numeric user id
    Given Delete user with non-numeric user id "<id>"
    When Send request delete user
    Then Status code should be 404
    Examples:
      |                           | id    |
      | alphabet                  | satu  |
      | special char              | !@#$% |
      | alphabet and special char | $thv$ |


