#A registered user can borrow a book independent from whether the administrator is logged in or not. If the user has already borrowed 10 books, he cannot borrow an 11th book. Instead a TooManyBookException is thrown with the error message "Can't borrow more than 10 books".


Feature: Borrow book 
    Description: The user borrows the book
    Actors: User

Scenario: User borrows a book succesfully
    Given there is a book with title "Extreme Programming", author "Kent Beck", and signature "Beck99"
    And a user is registered with the library
    When the user borrows the book
    Then the book is borrowed by the user

#  Scenario: The user tries to borrow the book again
#     Given the user is registered to the library
#     And  the book is in the library
#  	When the user borrows the book again
#     Then the user gets the message "Book is already borrowed"

Scenario: User borrows more than 10 books
    Given there is a book with signature "Beck99" is cointained in the library
    And a user is registered with the library
    And the user has borrowed 10 books
    When the user borrows the Book
    Then the book is not borrowed by the user
    And the error message "Can't borrow more than 10 books" is thrown
