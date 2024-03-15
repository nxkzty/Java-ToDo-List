package bbcag.src.menu;

import bbcag.src.menu.options.*;

import java.util.Scanner;

public class Menu {
    public void Menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n========ToDo========\n[1]\tView\n[2]\tAdd\n[3]\tDelete\n[4]\tEdit\n[5]\tFinish\n[6]\tExit");
        while (true){
            System.out.print("Choose a option: ");
            switch (scanner.nextLine()) {
                case "1":
                    View view = new View();
                    view.View();
                    break;
                case "2":
                    Add add = new Add();
                    add.Add();
                    break;
                case "3":
                    Delete delete = new Delete();
                    delete.Delete();
                    break;
                case "4":
                    Edit edit = new Edit();
                    edit.Edit();
                    break;
                case "5":
                    FinishToDo finishToDo = new FinishToDo();
                    finishToDo.FinishToDo();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("\nInvalid Input");
                    continue;
            }

            break;
        }
    }

    public void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }
}