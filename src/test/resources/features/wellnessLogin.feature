@WellnessLoginFeature
Feature: Corporate Wellness Form Validation

  Scenario Outline: Fill invalid details in Corporate Wellness form and capture warning message
    Given the user is on the Corporate Wellness page
    When the user fills in details with "<name>", "<organisation>", "<contact>", "<email>"
    And selects "501-1000" from the first dropdown
    And selects an option from the second dropdown
    Then the user should see respective invalid inputs highlighted in red
    And the schedule button is greyed out

    Examples: 
      | name         | organisation  | contact     | email              |
      | MichealScott | DunderMifflin | 09876543210 | M.Scott-Dunder.com |
