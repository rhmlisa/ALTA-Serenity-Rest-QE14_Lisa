Feature: Get Single User

  #Single User Scenario 1
  @Tugas
  Scenario Outline: Get single user with valid user id
    Given Get single user with user id <id>
    When Send request get list single user
    Then Status code should be 200
    And Response body id should be <id> and email is "<email>"
    And Validate json schema "SingleUserJsonSchema.json"
    Examples:
      | id | email                  |
      | 1  | george.bluth@reqres.in |
      | 2  | janet.weaver@reqres.in |

  #Single User Scenario 2
  @Tugas
  Scenario Outline: Get single user with non-existing user id
    Given Get single user with non-existing user id <id>
    When Send request get list single user
    Then Status code should be 404
    Examples:
      | id  |
      | -23 |
      | 24  |

  #Single User Scenario 3
  @Tugas
  Scenario Outline: Get single user with non-numeric user id
    Given Get single user with non-numeric user id "<id>"
    When Send request get list single user
    Then Status code should be 404
    Examples:
      |                           | id     |
      | alphabet                  | kookie |
      | special char              | @#$%^  |
      | alphabet and special char | $jjk!  |




