package bbcag.src.menu.options;

import bbcag.src.crud.DatabaseConnection;
import bbcag.src.menu.Menu;

import java.util.Locale;
import java.util.Scanner;


public class View {
    public void View() {
        DatabaseConnection databaseConnection = new DatabaseConnection("jdbc:mysql://localhost:3306/database_todo", "root", "1234");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n======VIEW======");

        Menu menu = new Menu();

        boolean validInput = false;
        while (!validInput) {
            System.out.print("\nDo you want to view the to-do's? (Y or N): ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("Y")) {
                menu.clearScreen();
                System.out.println("\n\n======VIEW======");
                databaseConnection.getAllObjects();
                menu.Menu();
                validInput = true;

            } else if (input.equals("N")) {
                validInput = true;
                menu.Menu();

            } else {
                System.out.println("Invalid Input");
                System.out.println("Try again");
            }
        }
    }
}
