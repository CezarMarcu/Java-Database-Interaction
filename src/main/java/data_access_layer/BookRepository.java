package data_access_layer;
import models_layer.Book;

import java.sql.*;

public class BookRepository {
    private final Connection connection;
    public static final String SQL_SAVE_BOOK = "INSERT INTO BOOKS (TITLE, AUTHOR,EDIT,LANGUAGE,PAGES,PAPERBACK,PUBLICATION_YEAR,IBSN,DIMENSIONS) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
}
