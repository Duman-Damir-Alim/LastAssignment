import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BookServiceImpl implements BookService {
    private static Map<Integer,Book> books = new HashMap<Integer, Book>();

    @Override
    public boolean addBook(Book b) {
        if(books.get(b.getId()) != null) return false;
        books.put(b.getId(),b);
        return true;
    }

    @Override
    public boolean deleteBook(int book_id) {
        if(books.get(book_id)!=null) return false;
        books.remove(book_id);
        return true;
    }

    @Override
    public Book getBook(int book_id) {
        return books.get(book_id);
    }

    @Override
    public Book[] getAllBooks() {
        Set<Integer> ids = books.keySet();
        Book[] b = new Book[ids.size()];
        int i = 0;
        for(Integer id: ids) {
            b[i] = books.get(id);
            i++;
        }
        return b;
    }
}
