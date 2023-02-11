package bussines_layer;

import data_access_layer.BookRepository;
import models_layer.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BussinesLogic {
    public void AddSingleBook(Book book) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:C:\\Users\\Cezar\\Desktop\\BooksDB\\Database\\Store");
        BookRepository repo = new BookRepository(connection);
//        Book book1 = new Book("Game of Thrones","George R.R. Martin", "Nemira","English","804","Brosata","2018","20x20x20");
        repo.saveBook(book);
        if (connection != null){
            connection.close();
        }
    }

}
