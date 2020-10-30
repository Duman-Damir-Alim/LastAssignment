import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private static List<Book> llist = new ArrayList<>();
    Connection getConnection() {
        Context initialContext = null;
        Connection connection = null;

        try {
            initialContext = new InitialContext();
            Context envCtx = (Context) initialContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/week");
            connection = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    protected ArrayList<Book> read(Connection connection){
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select*from books");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numOfColumns = metaData.getColumnCount();
            Book book;
            while(resultSet.next()) {
                String [] bookFields = new String[numOfColumns];
                for(int a = 1; a <= numOfColumns; a++) {
                    bookFields[a-1] = resultSet.getObject(a).toString();
                }
                book = new Book(bookFields);
                bookList.add(book);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return  bookList;
    }
    public static boolean checkLibrarian(String username, String password) {
        boolean st = false;
        try {
            DB db = new DB();
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM librarian WHERE username=? and password=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            st = resultSet.next();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
    public static boolean checkReader(String username, String password) {
        boolean st2 = false;
        try {
            DB db = new DB();
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM reader WHERE username=? and password=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            st2 = resultSet.next();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return st2;
    }
    public List<Book> listAll() {
        List<Book> books = new ArrayList<>();
        try {

            DB db = new DB();
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * From books");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
    public int add(String name, String author, int countOfCopies, String imageUrl) {
        int added = 0;
        try {
            DB db = new DB();
            Connection connection = db.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("Insert into book(book_name, author, countofcopies, book_url) VALUES (?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, author);
            preparedStatement.setInt(3, countOfCopies);
            preparedStatement.setString(4, imageUrl);
            added = preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return added;
    }

    protected int delete(String book_id) {
        int deleted = 0;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from book WHERE book_id =?");
            preparedStatement.executeQuery();
            preparedStatement.setString(1, book_id);
            connection.close();
            preparedStatement.close();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return deleted;
    }
    protected ArrayList<Book> search(String name) {
        ArrayList<Book> bookList = new ArrayList();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from books where book_name=? or author=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Book book;
            while(resultSet.next()) {
                String [] bookFields = new String[numberOfColumns];

            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return bookList;
    }

}
