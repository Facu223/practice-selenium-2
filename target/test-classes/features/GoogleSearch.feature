Feature: Test Google search functionality

@Test
Scenario: As a user I enter a search criteria in Google
    Given I am on the Google search page
    When I enter a search criteria
    And Click on the search button
    Then the results match the criteria
    Then the result is visible
    