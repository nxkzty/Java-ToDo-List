package bbcag.src.menu.options;

import bbcag.src.crud.DatabaseConnection;
import bbcag.src.menu.Menu;

import java.util.Locale;
import java.util.Scanner;

public class Add {
    public void Add() {
        DatabaseConnection databaseConnection = new DatabaseConnection("jdbc:mysql://localhost:3306/database_todo", "root", "1234");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n======ADD======");

        Menu menu = new Menu();

        boolean validInput = false;
        while (!validInput) {
            System.out.print("\nDo you want to add a to-do? (Y or N): ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("Y")) {
                menu.clearScreen();
                validInput = true;
                Scanner scanner1 = new Scanner(System.in);
                while (validInput) {

                    System.out.print("\nHow do you want to call the to-do: ");
                    String todo = scanner1.nextLine();
                    if (todo.length() > 100){
                        System.out.println("The text of the to-do is to long. ");
                        validInput = true;
                    }else {
                        System.out.print("\nOn which date do you want to finish the to-do (YYYY-MM-DD): ");
                        String todoDate = scanner1.nextLine();
                        databaseConnection.addNewToDo(todo, todoDate);
                        System.out.println("\n\nNew to-do has been added: " + todo);
                        break;
                    }




                }

            } else if (input.equals("N")) {
                    validInput = true;
                    menu.Menu();

                } else {
                    System.out.println("Invalid Input");
                    System.out.println("Try again");
                }


            }
        menu.Menu();
        }

}