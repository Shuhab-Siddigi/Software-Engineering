package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class User {

    private String CPR;
    private String name;
    private String email;
	private Address address;
    private List<Book> rentedBooks = new ArrayList<>(); 

    public User() {

    }

    public User(String CPR, String name, String email) {
        this.setCpr(CPR);
        this.setName(name);
        this.setEmail(email);
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCpr(String CPR) {
        this.CPR = CPR;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

	public void addBook(Book book) {
        this.rentedBooks.add(book);
	}

	public boolean hasBookWithSignature(String signature) {
        List<Book> book = rentedBooks.stream().filter(b -> // lambda
        b.getSignature().contains(signature)).collect(Collectors.toList());
        if (book.size() != 0 ){
            return true;
        }else {
            return false;
        }
    }

	public int numberOfRentedBooks() {
		return rentedBooks.size();
	}


	
}
