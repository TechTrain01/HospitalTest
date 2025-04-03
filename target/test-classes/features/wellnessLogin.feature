@Regression1
Feature: Corporate Wellness Form Validation

  @invalidLoginInput
  Scenario Outline: Fill Invalid details in Corporate Wellness form and capture warning message
    Given the user is on the Corporate Wellness page
    When the user fills in details with "<name>", "<organisation>", "<contact>", "<email>"
    And selects "501-1000" from the first dropdown
    And selects "Taking a demo" from the second dropdown
    Then the user should see respective invalid inputs highlighted in red
    And the schedule button is greyed out

    Examples: 
      | name         | organisation  | contact     | email                |
      | MichealScott | DunderMifflin | 09876543210 | M.Scott-Dunder.com   |
      | JimHalpert   | DunderMifflin |       12345 | J.Halpert@Dunder.com |

  @validLoginInput
  Scenario: Fill Valid details in Corporate Wellness form and capture successful pop-up notification
    Given the user is on the Corporate Wellness page
    When the user fills in details with "DwightSchrute", "DunderMifflin", "07123123123", "D.Schrute@Dunder.com"
    And selects "501-1000" from the first dropdown
    And selects "Taking a demo" from the second dropdown
    When the user clicks on the Schedule button
    Then the user should see Successful pop-up notification
