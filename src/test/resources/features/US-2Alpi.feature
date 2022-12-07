Feature: As a librarian, I want to know borrowed books number

	#https://library2.cydeo.com/login.html
  @TS27-114 @db
  Scenario: verify the total amount of borrowed books
    Given user login as a librarian
    When user take borrowed books number
    Then borrowed books number information must match with DB