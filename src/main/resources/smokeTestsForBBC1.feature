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

  Scenario Outline: Check secondary articles on news page
    Given User opens "https://www.bbc.com/"
    When User clicks news page link
    Then User checks correctness of '<titles>' of all secondary articles
    Examples:
      | titles                                                                                   |
      | Travis Scott 'devastated' by Texas festival deaths                                       |
      | Biden: Infrastructure bill is monumental step                                            |
      | Ex-PM condemns UK government as 'shameful'                                               |
      | Fleeing passengers shut down busy Spanish airport                                        |
      | Three injured in knife attack on German train                                            |
      | Greta Thunberg: COP26 is a failure and PR exercise                                       |
      | Brazil singer Mendonca dies in plane crash at 26                                         |
      | Ethiopia urges ex-soldiers to fight against rebels                                       |
      | Man found naked inside wall of US theatre                                                |
      | Ethiopia urges ex-soldiers to fight against rebels                                       |
      | Man found naked inside wall of US theatre                                                |
      | Chinese man convicted on aviation spy charges                                            |
      | Footballer struck by stray firework during game                                          |
      | Man City outclass Man Utd in derby win                                                   |
      | How the world is reacting to COP26                                                       |
      | The US state taking on an oil giant for greenwashing                                     |
      | Who is Greta Thunberg and what are her aims?                                             |
      | What you should know about climate change in Africa                                      |
      | 'By helping out delegates I'm remembering granddad'                                      |
      | Travis Scott 'devastated' by Texas festival deaths                                       |
      | BBC World News TV                                                                        |
      | BBC World Service Radio                                                                  |
      | All on show - the museum displaying everything                                           |
      | The teen art prodigy who's refusing to turn pro                                          |
      | Striking pictures from around the world this week                                        |
      | Colin Powell: Funeral for 'great lion with big heart'                                    |
      | Abandoned dog sells for $25k at auction                                                  |
      | Are Diwali fireworks to blame for Delhi smog?                                            |
      | As winter looms, reports of starvation in North Korea                                    |
      | Does the skyscraper still have a future?                                                 |
      | Covid delays student's journey from slum to Sydney                                       |
      | 'More than batons needed to control Ecuador's jails'                                     |
      | New ways into the lucrative world of data science                                        |
      | ‘As a child I saw the plane crash that killed my sisters'                                |
      | Lyse Doucet’s love letter to Kabul through nine treasured places                         |
      | Revealed: The Cryptoqueen's £13.5m London penthouse                                      |
      | How to end Ethiopia's suffering after a year of war                                      |
      | The city trying to save the world                                                        |
      | Why it's wrong to dismiss demisexuality                                                  |
      | The city where you can't serve meat                                                      |
      | Why Hollywood is shunning sex                                                            |
      | How China shapes the world's coal                                                        |
      | Penalised for showing emotion at work?                                                   |
      | The village that tamed a 100ft wave                                                      |
      | Autumn Nations Series: HT Wales 12-9 South Africa - Pollard late pen trims lead at break |
      | England into semi-finals despite narrow defeat by South Africa                           |
      | Barcelona surrender three-goal lead against Celta Vigo                                   |
      | Burnley 'stole point by pure luck' - Chelsea boss Tuchel                                 |
      | Rampant England claim 11-try win against Tonga as Smith sparks late flurry               |
      | 'I'm coming home' - Barca confirm Xavi return                                            |
