Feature: E2E Test

  Scenario: Test Checkout
    Given User navigates to the Login Page
    When User Login in to the Website
    And Change Dropdown from A-Z to Z-A
    And Add item to cat if the price is lower than $15.99
    Then Click on the Cart
    And Remove item if the price is greater than $9
    Then Click Check out
    Then Click on the Continue Button
    And Place assertion on the error
    Then Fill the form
    And Press the Continue Button
    Then Press the Finish Button
    And Get the thank you message
    Then Open a new tab
    And Fill in the credentials and press on the login button
    Then I should be logged in to system