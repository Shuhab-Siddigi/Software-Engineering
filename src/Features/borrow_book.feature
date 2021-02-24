# A registered user can borrow a book independent from whether the administrator is logged in or not. If the user has already borrowed 10 books, he cannot borrow an 11th book. Instead a TooManyBookException is thrown with the error message "Can't borrow more than 10 books".


 Feature: Borrow book 
    Description: The user borrows the book
    Actors: User
    
 Scenario: The user borrows a book
    Given the user is registered to the library
    #When the user borrows the book
#     Then the book is not in the library anymore

#  Scenario: The user tries to borrow the book again
#     Given the user is registered to the library
#     And  the book is in the library
#  	When the user borrows the book again
#     Then the user gets the message "Book is already borrowed"

