Feature: Get Books By City
    As a User
    I want [feature]
    So that I get in return a list of books

 Scenario Outline: Enter Valid City name
    Given The city is a '<city>'
    When Entering '<city>'
    Then I should get a '<page>'

Examples:
    | city     | page            | database |
    | Paris    | success         | mongodb  |
    | Paris    | success         | sql      |
    | Paris    | success         | postgres |

