public interface BookService {
    public boolean addBook(Book b);
    public boolean deleteBook(int book_id);
    public Book getBook(int book_id);
    public Book[] getAllBooks();
}
