Feature: USER API

  @Test
  Scenario: POST - User Registration
    Given Post user registration api
    Then Validation api response

  @Test
  Scenario: POST - User Login
    Given Post user login api
    Then Validation api response

  @Test
  Scenario: GET - User by UserId
    Given Get user by userId api
    Then Validation api response

#  @Test
#  Scenario: PUT - User Update
#    Given Put user by userId api
#    Then Validation api response
#
#  @Test
#  Scenario: Delete - User Delete
#    Given Delete user by userId api
#    Then Validation api response
