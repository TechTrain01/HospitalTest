@Regression
Feature: Search for hospitals in a specific city on Practo

	@MainPage
  Scenario: User searches for hospitals in Bangalore
    Given the user is on the Practo homepage
    When the user enters "Bangalore" into the city search field
    And the user selects "Bangalore" from the dropdown options
    And the user enters "Hospital" from the service search Field
    And the user selects "Hospital" from the service type dropdown
    Then the user should be navigated to the list of hospitals in Bangalore