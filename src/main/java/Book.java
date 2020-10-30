import java.io.Serializable;

public class Book implements Serializable{
    private static final long serialVersionUID = 668812036984863675L;
    private int book_id;
    private String name;
    private String author;
    private int countOfCopies;
    private String imageURL;

    public Book(String name, String author, int countOfCopies, String imageURL) {
        this.name = name;
        this.author = author;
        this.countOfCopies = countOfCopies;
        this.imageURL = imageURL;
    }
    public Book(String[] bookFields) {
        if(bookFields.length == 7) {
            this.book_id = Integer.parseInt(bookFields[0]);
            this.name = bookFields[1];
            this.author = bookFields[2];
            this.countOfCopies = Integer.parseInt(bookFields[3]);
            this.imageURL = bookFields[4];
        }
    }

    public int getId() {
        return book_id;
    }

    public void setId(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCountOfCopies() {
        return countOfCopies;
    }

    public void setCountOfCopies(int countOfCopies) {
        this.countOfCopies = countOfCopies;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", countOfCopies=" + countOfCopies +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
