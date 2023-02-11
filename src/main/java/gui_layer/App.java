package gui_layer;

import bussines_layer.BussinesLogic;
import models_layer.Book;


import java.sql.SQLException;
import java.util.Scanner;

public class App {
    private final BussinesLogic logic = new BussinesLogic();
    private final Scanner input = new Scanner(System.in);

    public void Run() throws SQLException {
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
        logic.AddSingleBook(newBook);
    }
}

