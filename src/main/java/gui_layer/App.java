package gui_layer;

import bussines_layer.BussinesLogic;
import models_layer.Book;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    private final BussinesLogic logic = new BussinesLogic();
    private final Scanner input = new Scanner(System.in);

    private void addNewBook() throws SQLException {
        input.nextLine();

        System.out.println("Book title:");
        String Title = input.nextLine();

        System.out.println("Author:");
        String Author = input.nextLine();

        System.out.println("Edit:");
        String Edit = input.nextLine();

        System.out.println("Language:");
        String Language = input.nextLine();

        System.out.println("Pages:");
        String Pages = input.nextLine();

        System.out.println("Paperback:");
        String Paperback = input.nextLine();

        System.out.println("Year of Publication:");
        String Year = input.nextLine();

        System.out.println("Dimensions:");
        String Dimensions = input.nextLine();

        Book newBook = new Book(Title, Author, Edit, Language, Pages, Paperback, Year, Dimensions);
        logic.addSingleBook(newBook);
        System.out.println("BOOK ADD WITH SUCCESS");
    }
    private void getBooks() throws SQLException{
        List<Book> books = logic.getBooks();
        for(Book book:books){
            System.out.println(book);
        }
    }
    private void deleteNullTitleBook()throws SQLException{
        logic.deleteNullTitleBooks();
        System.out.println("Book deleted with success");
    }


    public void Run() throws SQLException {

        boolean isRunning = true;

        while(isRunning){
            System.out.println("What do you want: Add Book (1) / Get Books (2)/ Delete book (3)");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> this.addNewBook();
                case 2 -> this.getBooks();
                case 3 -> this.deleteNullTitleBook();
                case 4 -> isRunning = false;
            }
        }

    }
}

