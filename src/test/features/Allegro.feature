Feature: Basket

  Scenario: Basket should contain added article to it

    Given Customer is on main page
    When He search for used "Laptop" article with price over 200 pln
    And  He add first result to a basket
    Then Basket contains selected article
