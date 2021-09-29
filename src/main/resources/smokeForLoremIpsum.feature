Feature: Smoke
  As a user I want to test correctness of text/word after clicking some buttons
  So that I can be sure that site works correctly


  Scenario Outline:
    Given User opens '<homePage>'
    When User clicks changing language button
    Then User checks correctness of '<keyword>'

    Examples:
      | homePage            | keyword |
      | https://lipsum.com/ | рыба    |

  Scenario Outline:
    Given User opens '<homePage>'
    When User clicks “Generate Lorem Ipsum” button
    Then User checks '<text>' on first paragraph

    Examples:
      | homePage            | text                                                    |
      | https://lipsum.com/ | Lorem ipsum dolor sit amet, consectetur adipiscing elit |