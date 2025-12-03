Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "demo@koel.dev"
    And I enter password "demo"
    And I click login
    Then I am logged in
