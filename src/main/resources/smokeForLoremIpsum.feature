Feature: Smoke
  As a user I want to test main functions of the site
  So that I can be sure that site works correctly


  Scenario Outline: Check correctness of word "рыба" after changing language to Russian (First part of task1)
    Given User opens '<homePage>'
    When User clicks changing language button
    Then User checks correctness of '<keyword>'

    Examples:
      | homePage            | keyword |
      | https://lipsum.com/ | рыба    |

  Scenario Outline: Check if first paragraph starts correctly after pressing “Generate Lorem Ipsum” button (Second part of task1)
    Given User opens '<homePage>'
    When User clicks “Generate Lorem Ipsum” button
    Then User checks '<text>' on first paragraph

    Examples:
      | homePage            | text                                                    |
      | https://lipsum.com/ | Lorem ipsum dolor sit amet, consectetur adipiscing elit |

  Scenario Outline: Check correctness of generation results with different input values/parameters (First part of task2)
    Given User opens '<homePage>'
    And User put parameter(10) to input field
    And User clicks *words* radio button
    When User clicks “Generate Lorem Ipsum” button
    Then User checks "10 words" result of generation
    Given User opens '<homePage>'
    And User put parameter(-1) to input field
    And User clicks *words* radio button
    When User clicks “Generate Lorem Ipsum” button
    Then User checks "5 words" result of generation
    Given User opens '<homePage>'
    And User put parameter(0) to input field
    And User clicks *words* radio button
    When User clicks “Generate Lorem Ipsum” button
    Then User checks "5 words" result of generation
    Given User opens '<homePage>'
    And User put parameter(5) to input field
    And User clicks *words* radio button
    When User clicks “Generate Lorem Ipsum” button
    Then User checks "5 words" result of generation
    Given User opens '<homePage>'
    And User put parameter(20) to input field
    And User clicks *words* radio button
    When User clicks “Generate Lorem Ipsum” button
    Then User checks "20 words" result of generation
    Given User opens '<homePage>'
    And User put parameter(20) to input field
    And User clicks *bytes* radio button
    When User clicks “Generate Lorem Ipsum” button
    Then User checks "20 bytes" result of generation
    Given User opens '<homePage>'
    And User put parameter(1) to input field
    And User clicks *bytes* radio button
    When User clicks “Generate Lorem Ipsum” button
    Then User checks "3 bytes" result of generation
    Given User opens '<homePage>'
    And User put parameter(0) to input field
    And User clicks *bytes* radio button
    When User clicks “Generate Lorem Ipsum” button
    Then User checks "5 bytes" result of generation
    Given User opens '<homePage>'
    And User put parameter(-1) to input field
    And User clicks *bytes* radio button
    When User clicks “Generate Lorem Ipsum” button
    Then User checks "5 bytes" result of generation

    Examples:
      | homePage            |
      | https://lipsum.com/ |

  Scenario Outline: Check that after clicking checkbox text is not started with false result (Second part of task2)
    Given User opens '<homePage>'
    And User clicks on checkbox near to “Generate Lorem Ipsum” button
    When User clicks “Generate Lorem Ipsum” button
    Then User checks that text not starts with '<falseResult>'

    Examples:
      | homePage            | falseResult |
      | https://lipsum.com/ | Lorem ipsum |