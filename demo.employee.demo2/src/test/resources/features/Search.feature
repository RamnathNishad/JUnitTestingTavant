Feature: Amazon Search Functionality
  Scenario: Product Search
    Given I have a search field on the Amazon page
    When I search for "laptop"
    And Price is greater than 10000
    Then I expect a laptop related results