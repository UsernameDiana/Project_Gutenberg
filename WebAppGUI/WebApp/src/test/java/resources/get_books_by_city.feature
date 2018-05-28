Feature: Get Books By City
    As a User
    I want to type in a city
    So that I get a list of books in return

 Scenario Outline: Enter Valid City name
    Given Opening the page
    When Entering '<city>'
    Then I should get results

Examples:
    | city     |
    | Paris    | 

