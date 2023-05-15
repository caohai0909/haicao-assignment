Feature: Search Product

  @Test
  Scenario: TC_01 [Search Product] Automate 'Search Product'
    Given I went to shop page
    When I search by keyword
      |Keyword  |Results              |
      |Selenium |Selenium Ruby        |
      |Python   |Sorry, nothing found.|
    Then Validation search results