Feature: As a User, I want to be able to navigate the Hacker News Website.
  Scenario: Navigating to the past page from the home page
    Given I am on the Hacker News Website
    When I click the past link
    Then i will go to the past page


  Scenario: Searching for the term java
    Given I am on the Hacker News Website
    When I search for the term java
    Then I will receive a list of stories based on java

  Scenario: Navigating to the comments page from home page
    Given I am on the Hacker News Website
    When I click on the comments link
    Then I will go to the comments page

  Scenario: Navigating to the job page from the home page
    Given I am on the Hacker News Website
    When I click on the jobs link
    Then I will go the the jobs page

  Scenario: Navigating to the ask page from the home page
    Given I am on the Hacker News Website
    When I click on the ask link
    Then I will go to the ask page

 Scenario: Navigating to the show page from the home page
   Given I am on the Hacker News Website
   When I click on the show page
   Then I will go to the show page

