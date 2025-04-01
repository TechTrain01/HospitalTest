Feature: Search for hospitals with specific criteria
 Scenario: User searches for hospitals in Bangalore with 24/7 access and rating and parking
    Given the user is on the hospital Menu page
    When the user clicks on the "<hospital name>"
    Then the user should be navigated to the hospital listings page
    And the user should see the hospital opening times
    And the user should see a rating of the hospital
    When user clicks the read more drop down
    Then the user should see parking in the Amenities block