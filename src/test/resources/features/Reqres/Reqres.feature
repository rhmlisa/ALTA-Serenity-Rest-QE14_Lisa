Feature: Serenity Rest QE 14
  Scenario Outline: Get list users with valid parameter page
    Given Get list user with parameter page <page>
    When Send request get list users
    Then Status code should be 200
    Examples:
      | page |
      | 1    |
      | 2    |

    Scenario: Post create user with valid json
      Given Create user with valid json "CreateUser.json"
      When Send request create new user
      Then Status code should be 201
