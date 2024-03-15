package bbcag.src.menu.options;

import bbcag.src.crud.DatabaseConnection;
import bbcag.src.menu.Menu;

import java.util.Scanner;

public class Delete {
    public void Delete() {
        DatabaseConnection databaseConnection = new DatabaseConnection("jdbc:mysql://localhost:3306/database_todo", "root", "1234");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n======Delete======");

        Menu menu = new Menu();

        boolean validInput = false;
        while (!validInput) {
            System.out.print("\nDo you want to delete a to-do? (Y or N): ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("Y")) {
                menu.clearScreen();
                Scanner todo = new Scanner(System.in);

                databaseConnection.getAllObjects();
                System.out.print("\nWhich to-do you want to delete: ");
                int todo_id = todo.nextInt();
                databaseConnection.deleteToDo(todo_id);

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
