Feature: Products channel
  Scenario: Ask for a demo
    Given I am in the home page
    When I click on Products
    And select Ver Demo
    Then I should see a form to fill