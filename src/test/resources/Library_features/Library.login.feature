Feature: User should be able to login using multiple credentials

Scenario: Login as a student
  Given Student is on library landing page
  When Student logs in
  Then Student should see the books table

Scenario: Login as Librarian
  Given Librarian is on landing page
  When Librarian logs in
  Then Librarian should see User, Books and Borrowed books

