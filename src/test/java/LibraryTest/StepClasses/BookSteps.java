package LibraryTest.StepClasses;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import Library.Book;
import Library.ErrorMessageHolder;
import Library.LibraryApp;
import Library.OperationNotAllowedException;
import LibraryTest.HelperClasses.UserHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookSteps {
    
    private LibraryApp libraryApp;
    private Book book;
    private ErrorMessageHolder errorMessageHolder;
    private UserHelper user;
    private List<Book> books = new ArrayList<>();


    public BookSteps(LibraryApp libraryApp, ErrorMessageHolder errorMessageHolder, UserHelper helper) {
        this.libraryApp = libraryApp;
        this.errorMessageHolder = errorMessageHolder;
        this.user = helper;
    }

    @Given("there is a book with title {string}, author {string}, and signature {string}")
    public void thereIsABookWithTitleAuthorAndSignature(String title, String author, String signature) {
    book = new Book(title,author,signature);
    assertEquals(book.getTitle(), title);
    assertEquals(book.getSignature(), signature);
    assertEquals(book.getAuthor(), author);
    }

    
	@Given("the book is not in the library")
	public void theBookIsNotInTheLibrary() {
       assertFalse(libraryApp.containsBookWithSignature(book.getSignature()));
	}


	
	@Given("these books are contained in the library")
	public void theseBooksAreContainedInTheLibrary(List<List<String>> books) throws Exception {
		for (List<String> bookInfo : books) {
			libraryApp.addBook(new Book(bookInfo.get(0), bookInfo.get(1), bookInfo.get(2)));
		}
	}
	
	@When("the book is added to the library")
	public void bookIsAddedToTheLibrary() {
		try {
			libraryApp.addBook(book);
		} catch (OperationNotAllowedException e) {
			errorMessageHolder.setErrorMessage(e.getMessage());
		}
	}

	@Then("the book with title {string}, author {string}, and signature {string} is contained in the library")
	public void theBookWithTitleAuthorAndSignatureIsContainedInTheLibrary(String title, String author, String signature)
			throws Exception {
		assertTrue(libraryApp.containsBookWithSignature(signature));
	}

	@Then("the error message {string} is given")
	public void theErrorMessageIsGiven(String errorMessage) throws Exception {
		assertEquals(errorMessage, this.errorMessageHolder.getErrorMessage());
	}

	@Given("the library has a book with title {string}, author {string}, and signature {string}")
	public void theLibraryHasABookWithTitleAuthorAndSignature(String title, String author, String signature)
			throws Exception {
		Book book = new Book(title, author, signature);
		libraryApp.addBook(book);
	}

	@When("the user searches for the text {string}")
	public void theUserSearchesForTheText(String searchText) throws Exception {
		books = libraryApp.search(searchText);
	}

	@Then("the book with signature {string} is found")
	public void theBookWithSignatureIsFound(String signature) throws Exception {
		assertEquals(1, books.size());
		assertEquals(signature, books.get(0).getSignature());
	}

	@Then("no books are found")
	public void noBooksAreFound() throws Exception {
		assertTrue(books.isEmpty());
	}

	@Then("the books with signatures {string} and {string} are found")
	public void theBooksWithSignaturesAndAreFound(String signature1, String signature2) throws Exception {
		assertEquals(2, books.size());
		Book book1 = books.get(0);
		Book book2 = books.get(1);
		assertTrue((book1.getSignature().equals(signature1) && book2.getSignature().equals(signature2))
				|| (book1.getSignature().equals(signature2) && book2.getSignature().equals(signature1)));
	}


	
}



