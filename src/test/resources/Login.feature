Feature: As user I want to be able to login under different roles
# this is a comment

Scenario: Login as a sales manager

  Given user is on the landing page
  When user logs in
  Then user should see dashboard page


Scenario: Login as a driver

  Given driver is on the landing page
  When driver logs in
  Then driver should see dashboard