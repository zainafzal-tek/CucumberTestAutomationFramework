@login
Feature: As user I want to be able to login under different roles
# this is a comment
# Background - test pre-condition
# will be executed before every scenario in the particular feature filed

  Background: common steps
    Given user is on the landing page

  Scenario: Login as a sales manager
    When user logs in
    Then user should see "dashboard" page

  @parametrized_test
  Scenario: Parametrized login
    When user logs in as a "store manager"
    Then user should see "dashboard" page

# @s_o = scenario outline
  @parametrized_test @smoke_test @s_o
  Scenario Outline: Parametrized login as <role>
    When user logs in as a "<role>"
    Then user should see "<page_title>" page

    Examples:
      | role          | page_title |
      | sales manager | Dashboard  |
      | store manager | Dashboard  |
      | driver        | Dashboard  |

# role - variable. You can name parameters as you want
# 1st row is always reserved for parameters


#"driver" - is a parameter. "" allows to do test parametrization which helps to re-use test steps

  @negative_login
  Scenario: Invalid Password
    When user logs in with "storemanager85" username and "wrong" password
    Then user verifies that "Invalid user name or password." message is displayed

  @negative_scenario_outline
  Scenario Outline: Invalid Login with <username> and <password>
    When user logs in with "<username>" username and "<password>" password
    Then user verifies that "<message>" message is displayed

    #for every test set the test would run. this is useful for checking every kind of scenario regarding negative scenario
    Examples: data set
      | username | password | message                        |
      | wrong    | bad      | Invalid user name or password. |
      | wrong    | bad      | Invalid user name or password. |
      | wrong    | bad      | Invalid user name or password. |
      | wrong    | bad      | Invalid user name or password. |
