package Library;

public class Book {

    private String title;
    private String author;
    private String signature;

    public Book(String title, String author, String signature) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setSignature(signature);

    }

    public Book() {
	}

	public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
