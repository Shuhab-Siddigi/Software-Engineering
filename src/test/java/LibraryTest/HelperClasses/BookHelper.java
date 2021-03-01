package LibraryTest.HelperClasses;

import java.util.ArrayList;
import java.util.List;

import Library.Book;
import Library.LibraryApp;
import Library.OperationNotAllowedException;

public class BookHelper {
	LibraryApp libraryApp;

	public BookHelper(LibraryApp libraryApp) {
		this.libraryApp = libraryApp;
	}

	public void addBooksToLibrary(List<Book> exampleBooks) throws OperationNotAllowedException {
		boolean adminLoggedIn = libraryApp.adminLoggedIn();
		if (!adminLoggedIn) {
			libraryApp.adminLogin("adminadmin");
		}
		for (Book b : exampleBooks) {
			libraryApp.addBook(b);
		}
		if (!adminLoggedIn) {
			libraryApp.adminLogout();
		}
	}

	public List<Book> getExampleBooks(int n) {
		List<Book> books = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			books.add(new Book("title" + i, "author" + i, "signature" + i));
		}
		return books;
	}
	
	public List<Book> addExampleBooks(int n) throws OperationNotAllowedException {
		List<Book> books = getExampleBooks(n);
		addBooksToLibrary(books);
		return books;
	}
}
