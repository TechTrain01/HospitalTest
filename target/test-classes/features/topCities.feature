@Regression
Feature: Diagnostics Page

	@TopCities
  Scenario: Verify the appearance of top cities on the diagnostics page
    Given I am on the homepage
    When I navigate to the diagnostics page
    Then I should see the top cities banner pop-up
    And the top cities should be visible