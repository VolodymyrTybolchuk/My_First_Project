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
    Given User opens "https://lipsum.com/"
    And User put parameter'<parameter>' to input field
    And User clicks *words* radio button
    When User clicks “Generate Lorem Ipsum” button
    Then User checks '<result>' result of generation

    Examples:
      | parameter | result   |
      | 10        | 10 words |
      | -1        | 5 words  |
      | 0         | 5 words  |
      | 5         | 5 words  |
      | 20        | 20 words |
      | 20        | 20 bytes |
      | 1         | 3 bytes  |
      | 0         | 5 bytes  |
      | -1        | 5 bytes  |

  Scenario Outline: Check that after clicking checkbox text is not started with false result (Second part of task2)
    Given User opens '<homePage>'
    And User clicks on checkbox near to “Generate Lorem Ipsum” button
    When User clicks “Generate Lorem Ipsum” button
    Then User checks that text not starts with '<falseResult>'

    Examples:
      | homePage            | falseResult |
      | https://lipsum.com/ | Lorem ipsum |

  Scenario Outline: Check average amount of paragraph that contains word "lorem", after 10 generation (Third part of task2)
    Given User opens '<homePage>'
    When User clicks “Generate Lorem Ipsum” button
    And User determines number of each paragraph that contains '<word>'
    Then User checks if average number of paragraphs that contains keyword is more then '<boundaryValue>'

    Examples:
      | homePage            | word  | boundaryValue |
      | https://lipsum.com/ | lorem | 2             |
      | https://lipsum.com/ | lorem | 2             |
      | https://lipsum.com/ | lorem | 2             |
      | https://lipsum.com/ | lorem | 2             |
      | https://lipsum.com/ | lorem | 2             |
      | https://lipsum.com/ | lorem | 2             |
      | https://lipsum.com/ | lorem | 2             |
      | https://lipsum.com/ | lorem | 2             |
      | https://lipsum.com/ | lorem | 2             |
      | https://lipsum.com/ | lorem | 2             |