Feature: Get Books By City
  Return list of books

  Scenario Outline: Enter Valid City name
    Given The city is '<city>'
    When Entering '<city>' and choosing '<database>'
    Then I should get '<page>'

Examples:
    | city     | page            | database |
    | Paris    | success         | mongodb  |

