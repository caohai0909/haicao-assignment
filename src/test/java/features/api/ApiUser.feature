Feature: USER API

  Scenario: POST - User Registration
    Given Post user registration api
    Then Validation api response

  Scenario: POST - User Login
    Given Post user login api
    Then Validation api response

  Scenario: GET - User by UserId
    Given Get user by userId api
    Then Validation api response


  Scenario: PUT - User Update
    Given Put user by userId api
    Then Validation api response

  Scenario: Delete - User Delete
    Given Delete user by userId api
    Then Validation api response
