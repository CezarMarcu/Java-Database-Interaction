package data_access_layer;
import models_layer.Book;

import java.sql.*;

public class BookRepository {
    private final Connection _connection;
    public static final String SQL_SAVE_BOOK = "INSERT INTO BOOKS (TITLE, AUTHOR,EDIT,LANGUAGE,PAGES,PAPERBACK,PUBLICATION_YEAR,IBSN,DIMENSIONS) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public BookRepository(Connection connection){
        _connection = connection;
    }

    public void saveBook(Book book){

        try {
            PreparedStatement ps = _connection.prepareStatement(BookRepository.SQL_SAVE_BOOK, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,book.get_title());
            ps.setString(2,book.get_author());
            ps.setString(3,book.get_edit());
            ps.setString(4,book.get_language());
            ps.setString(5,book.get_pages());
            ps.setString(6,book.get_paperback());
            ps.setString(7,book.get_publicationYear());
            ps.setString(8,book.get_IBSN());
            ps.setString(9,book.get_dimensions());
            int recordsAffected = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                long id = rs.getLong(1);
                book.set_id(id);
            }
            System.out.printf("Records affected: %d%n%n",recordsAffected);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
