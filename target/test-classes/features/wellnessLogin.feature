Feature: Corporate Wellness Form Validation

  Scenario Outline: Fill invalid details in Corporate Wellness form and capture warning message
    Given the user is on the Corporate Wellness page
    When the user fills in details with "<name>", "<organisation>", "<contact>", "<email>", "<dropdown1>", and "<dropdown2>"
    And the user schedules an appointment
    Then the user should see a warning message

    Examples: 
      | name        | organisation | contact     | email                   | dropdown1 | dropdown2 |
      | AliceBrowna | Org1         | 09876543210 | alice.brown-example.com | <500   | Option2   |
      | AliceBrowna | Org12        |       12345 | alice.brown@example.com | Option1   | Option2   |
