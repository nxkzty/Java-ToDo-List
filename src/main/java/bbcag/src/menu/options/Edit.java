package bbcag.src.menu.options;

import bbcag.src.crud.DatabaseConnection;
import bbcag.src.menu.Menu;
import bbcag.src.menu.Menu.*;

import java.util.Scanner;

public class Edit {
    public void Edit() {
        DatabaseConnection databaseConnection = new DatabaseConnection("jdbc:mysql://localhost:3306/database_todo", "root", "1234");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n======EDIT======");

        Menu menu = new Menu();

        boolean validInput = false;
        while (!validInput) {
            System.out.print("\nDo you want to edit a to-do? (Y or N): ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("Y")) {
                menu.clearScreen();
                databaseConnection.getAllObjects();
                System.out.print("\nWhich To-Do do you want to edit? ");
                int inputId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("\nWhat should be the new text? ");
                String newText = scanner.nextLine();
                databaseConnection.editToDo(inputId, newText);
                menu.Menu();

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
