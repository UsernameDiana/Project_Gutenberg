Feature: Get Books By City
    As a User
    I want [feature]
    So that I get in return a list of books

 Scenario Outline: Enter Valid City name
    Given Opening the page
    When Entering '<city>'
    Then I should get results

Examples:
    | city     |
    | Paris    | 

