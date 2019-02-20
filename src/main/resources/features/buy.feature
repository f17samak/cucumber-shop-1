Feature: Buy products
    As a manager
    I want to manage inventory of product stocks
    So that we know when the order can be fulfilled.

Background:
    Given a product Bread with quantity 20 price 25.00
    And a product Cheese with quantity 10 price 15.00

Scenario: Buy from product stocks
    When I buy Bread with quantity 5
    Then total should be 125.00
    Then there's 15 items of Bread left

Scenario: Buy and get stock empty
    When I buy Cheese with quantity 10
    Then total should be 150.00
    Then there's 0 items of Cheese left

Scenario: Buy multiple products from stock products
    When I buy Bread with quantity 10
    And I buy Cheese with quantity 5
    Then total should be 325
    Then there's 10 items of Bread left
    And there's 5 items of Cheese left


