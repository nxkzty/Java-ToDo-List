package bbcag.src.menu.options;

import bbcag.src.crud.DatabaseConnection;
import bbcag.src.menu.Menu;

import java.util.Scanner;

public class FinishToDo {
    public void FinishToDo() {
        DatabaseConnection databaseConnection = new DatabaseConnection("jdbc:mysql://localhost:3306/database_todo", "root", "1234");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n======FINISH======");

        Menu menu = new Menu();

        boolean validInput = false;
        while (!validInput) {
            System.out.print("\nDo you want to finish a to-do? (Y or N): ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("Y")) {

                menu.clearScreen();
                databaseConnection.getStillDueObjects();

;
                System.out.println("Which to-do do you want to finish: ");
                int inputId = scanner.nextInt();
                menu.clearScreen();
                databaseConnection.finishToDo(inputId);
                menu.clearScreen();
                System.out.println("To-do " + inputId + " is finished now!");
                menu.Menu();
            } else if (input.equals("N")) {
                validInput = true;
                menu.Menu();

            } else {
                System.out.println("Invalid Input");
                System.out.println("Try again");
            }
        }}
}
