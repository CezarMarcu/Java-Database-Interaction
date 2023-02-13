package data_access_layer;
import models_layer.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private final Connection connection;
    public static final String SQL_SAVE_BOOK = "INSERT INTO BOOKS (TITLE, AUTHOR,EDIT,LANGUAGE,PAGES,PAPERBACK,PUBLICATION_YEAR,IBSN,DIMENSIONS) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_GET_BOOKS = "SELECT * FROM BOOKS";
    public static final String SQL_DELETE_NO_TITLE_BOOK = "DELETE FROM BOOKS WHERE TITLE = ''";
    public BookRepository(Connection connection){this.connection = connection;}

    public void saveBook(Book book){
        try {
            PreparedStatement ps = connection.prepareStatement(BookRepository.SQL_SAVE_BOOK, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,book.getTitle());
            ps.setString(2,book.getAuthor());
            ps.setString(3,book.getEdit());
            ps.setString(4,book.getLanguage());
            ps.setString(5,book.getPages());
            ps.setString(6,book.getPaperback());
            ps.setString(7,book.getPublicationYear());
            ps.setString(8,book.getIBSN());
            ps.setString(9,book.getDimensions());
            int recordsAffected = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                long id = rs.getLong(1);
                book.setId(id);
            }
            System.out.printf("Records affected: %d%n%n",recordsAffected);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement(BookRepository.SQL_GET_BOOKS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                books.add(new Book(
                        rs.getLong("ID"),
                        rs.getString("TITLE"),
                        rs.getString("AUTHOR"),
                        rs.getString("EDIT"),
                        rs.getString("LANGUAGE"),
                        rs.getString("PAGES"),
                        rs.getString("PAPERBACK"),
                        rs.getString("PUBLICATION_YEAR"),
                        rs.getString("IBSN"),
                        rs.getString("DIMENSIONS")));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return books;
    }
    public void deleteNullTitleBook(){
        try{
            PreparedStatement ps = connection.prepareStatement(BookRepository.SQL_DELETE_NO_TITLE_BOOK);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }



    }
}
