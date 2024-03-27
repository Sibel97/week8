Feature: As a User, I want to be able to navigate the Hacker News Website.
  Scenario: Navigating to the past page from the home page
    Given I am on the Hacker News Website
    When I click the past link
    Then i will go to the past page


  Scenario: Searching for the term java
    Given I am on the Hacker News Website
    When I search for the term java
    Then I will receive a list of stories based on java