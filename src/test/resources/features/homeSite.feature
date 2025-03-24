Feature: Search for hospitals in a specific city on Practo

  Scenario: User searches for hospitals in Bangalore
    Given the user is on the Practo homepage
    When the user enters "Bangalore" into the city search field
    And the user selects "Hospital" from the service type dropdown
    And the user clicks the "Search" button
    Then the user should be navigated to the list of hospitals in Bangalore
    And the user should see a list of hospitals in Bangalore