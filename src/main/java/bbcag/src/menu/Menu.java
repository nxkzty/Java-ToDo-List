package bbcag.src.menu;

import bbcag.src.menu.options.Add;
import bbcag.src.menu.options.Delete;
import bbcag.src.menu.options.Edit;
import bbcag.src.menu.options.View;

import java.util.Scanner;

public class Menu {
    public void Menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n========Menu========\n[1]\tView ToDo\n[2]\tCreate ToDo\n[3]\tDelete ToDo\n[4]\tEdit ToDo\n");
        System.out.print("Choose a option: ");
        switch (scanner.nextInt()) {
            case 1:
                View view = new View();
                view.View();
                break;
            case 2:
                Add add = new Add();
                add.Add();
                break;
            case 3:
                Delete delete = new Delete();
                delete.Delete();
                break;
            case 4:
                Edit edit = new Edit();
                edit.Edit();
                break;
            default:
                System.out.println("Invalid Number");
        }

    }
    public void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }





}
