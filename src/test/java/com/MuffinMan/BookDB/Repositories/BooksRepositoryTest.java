package com.MuffinMan.BookDB.Repositories;
import data_access_layer.BookRepository;
import models_layer.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BooksRepositoryTest {

    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:C:\\Users\\Cezar\\Desktop\\BooksDB\\Database\\Store");
    }
    @AfterEach
    void tearDown() throws SQLException {
        if (connection != null){
            connection.close();
        }
    }

    @Test
    public void canOneSaveBook() {
        BookRepository repo = new BookRepository(connection);
        Book book1 = new Book("Game of Thrones","George R.R. Martin", "Nemira","English","804","Brosata","2018","20x20x20");
        repo.saveBook(book1);
    }
    @Test
    public void canGetBooks(){
        BookRepository repo = new BookRepository(connection);
        List<Book> books = repo.getBooks();
        for(Book item : books){
            System.out.println(item);
        }
    }
    @Test
    public void canDeleteNoTitleBook(){
        BookRepository repo = new BookRepository(connection);
        repo.deleteNullTitleBook();
        System.out.println("Book deleted with success");
    }
}


