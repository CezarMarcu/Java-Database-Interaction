package bussines_layer;
import data_access_layer.BookRepository;
import models_layer.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class BussinesLogic {
    public void addSingleBook(Book book) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:C:\\Users\\Cezar\\Desktop\\BooksDB\\Database\\Store");
        BookRepository repo = new BookRepository(connection);
//        Book book1 = new Book("Game of Thrones","George R.R. Martin", "Nemira","English","804","Brosata","2018","20x20x20");
        repo.saveBook(book);
        if (connection != null){
            connection.close();
        }
    }
    public List<Book> getBooks() throws  SQLException{
        Connection connection = DriverManager.getConnection("jdbc:h2:C:\\Users\\Cezar\\Desktop\\BooksDB\\Database\\Store");
        BookRepository repo = new BookRepository(connection);
        List<Book> books = repo.getBooks();

        if(connection != null) {
            connection.close();
        }
        return books;
    }
    public void deleteNullTitleBooks()throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:h2:C:\\Users\\Cezar\\Desktop\\BooksDB\\Database\\Store");
        BookRepository repo = new BookRepository(connection);
        repo.deleteNullTitleBook();
        if(connection != null) {
            connection.close();
        }

    }
}
