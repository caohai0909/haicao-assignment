Feature: User Registration


  @Test
   Scenario: TC_01 [User Registration] Automate User Registration Process
    Given I went to user registration page
    When I enter all information in Volunteer Sign Up section
    |FirstName|LastName|Phone     |Country|City   |EmailAddress         |Gender|DaysOfWeek              |BestTimeToContact|UploadFiles|
    |Hai      |Cao     |0584002879|VietNam|SaiGon |caohai0909@gmail.com |Male  |Sunday;Monday;Wednesday |Afternoon        |           |
    And I click to Submit button
    Then Validate that user is created or failed to create

  @Test
  Scenario: TC_02 [User Registration] Verify invalid email address error
    Given I went to user registration page
    When I enter invalid to email address and click enter
    Then Validation that invalid email error message is displayed

  @Test
  Scenario: TC_03 [User Registration] Verify Drag and Drop ability on website
    Given I went to user registration page
    When I do drag and drop for demonstrate
    Then Validation drag and drop is successfully