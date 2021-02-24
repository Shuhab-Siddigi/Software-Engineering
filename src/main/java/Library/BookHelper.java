package Library;

import java.util.List;

public class BookHelper {
    
    private List<Book> books;
    private LibraryApp libraryApp;

    public BookHelper(LibraryApp libraryApp) {
        this.libraryApp = libraryApp;
    }

    public List<Book> getBooks() {
        if (books == null) {
        books = exampleBooks();
        }
        return books;
    }
    
    public void addBooks(String title, String author, String signature) {
        Book b = new Book(title,author,signature);
        if(!books.contains(b)){
        books.add(b);
        }
    }

    private List<Book> exampleBooks() {
        books.add( new Book( "Extreme Programming" , "Kent Beck" , "Beck99"));
        books.add( new Book("Test Driven Development" , "Kent Beck" , "Beck02"));
        books.add( new Book("Lean Software Development" , "Mary Poppendieck and Tom Poppendieck" , "Pop07"));
        books.add( new Book("Cucumber for Java" , "Seb Rose" , "Rose11"));
        return books;
    }
    
}
