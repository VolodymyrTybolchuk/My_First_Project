Feature: Smoke
  As a user I want to test main functions of the site
  So that I can be sure that site works correctly

  Scenario Outline: Check main article on news page
    Given User opens '<page>'
    When User clicks news page link
    Then User checks name correctness of main '<article>'
    Examples:
      | page                 | article                                      |
      | https://www.bbc.com/ | Scores dead in Sierra Leone tanker explosion |

  Scenario: Check secondary articles on news page
    Given User opens '<https://www.bbc.com/>'
    When User clicks news page link
    Then User checks correctness of all secondary articles titles

  Scenario Outline: Check search result by enter text of category link like search input
    Given User opens '<page>'
    And User clicks news page link
    When User makes search by text of category link
    Then User checks name correctness of first founded article '<nameOfTheFirstFoundedArticle>'
    Examples:
      | page                 | nameOfTheFirstFoundedArticle |
      | https://www.bbc.com/ | Cities of Europe             |

