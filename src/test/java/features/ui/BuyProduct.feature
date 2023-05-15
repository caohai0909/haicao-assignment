Feature: Buy Product

  @Test
  Scenario: TC_01 [Buy Product] Automate End to End Buy Order functionality
    Given I went to shop page
    When I add product to cart
    |ProductName          |ProductPrice |
    |Mastering JavaScript |350.00       |
    And I go to cart
    And I process checkout
    And I enter billing details
    |FirstName|LastName |CompanyName  |EmailAddress         |Phone      |Country|Address         |PostcodeZip |TownCity|OrderNotes        |PaymentMethod        |
    |Hai      |Cao      |ABC Company  |caohai0909@gmail.com |0584002879 |Vietnam|123 Ho Chi Minh |70000       |HCM city|Be careful my box |Direct Bank Transfer |
    And I click to proceed order
    Then Validation result via screenshot

  @Test
  Scenario: TC_02 [Buy Product] Verify that Total Price is reflecting correctly if user changes quantity on 'Shopping Cart Summary' Page
    Given I went to shop page
    When I add product to cart
      |ProductName          |
      |Mastering JavaScript |
    And I go to cart
    And I change product quantity
      |ProductName          |ProductPrice |ProductQuantity|
      |Mastering JavaScript |350.00       |4              |
    Then validation that total price is changing and reflecting correct price