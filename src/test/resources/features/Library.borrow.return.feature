Feature: Student should be able to borrow and return a book

Scenario: Student should be able to choose from different book categories

  Given Student is on dashboard
  When Student clicks on book categories drop-down
  Then Student should see all categories of books available