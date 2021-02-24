package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryApp {

	private boolean adminLoggedIn = false;
	private List<Book> books = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	private static final int MAXNUMBEROFBOOKS = 10;

	public boolean containsBookWithSignature(String signature) {
		return books.stream().anyMatch(b -> b.getSignature().contentEquals(signature));
	}

	public boolean adminLoggedIn() {
		return adminLoggedIn;
	}

	public boolean adminLogin(String password) {
		if ( password.equals("adminadmin")){
			adminLoggedIn = true;
		}
		return adminLoggedIn;
	}

	public void adminLogout() {
		adminLoggedIn = false;
	}

	public void registerUser(User user) throws OperationNotAllowedException {
		if (!adminLoggedIn){
			throw new OperationNotAllowedException("Administrator login required");
		}
		if (users.contains(user)){
			throw new OperationNotAllowedException("User is already registered");
		}
		users.add(user);
	}

	public boolean isRegistered(User user) throws OperationNotAllowedException {
		if (!users.contains(user)){
			throw new OperationNotAllowedException("The user is not registered");
		}else{
			return true;
		}
	}

	public void addBook(Book book) throws OperationNotAllowedException {
		if (!adminLoggedIn){
			throw new OperationNotAllowedException("Administrator login required");
		}
		if (books.contains(book)){
			throw new OperationNotAllowedException("The book is already in the library");
		}
		books.add(book);
	}

	public List<Book> search(String searchText) {
		return books.stream().filter(b ->  //lambda
			b.getSignature().contains(searchText) ||
			b.getAuthor().contains(searchText) 	  ||
			b.getTitle().contains(searchText)).collect(Collectors.toList());
	}
	
	
}
