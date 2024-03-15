package bbcag.src;

import bbcag.src.menu.Menu;
import bbcag.src.crud.*;

public class Main {
    public static void main(String[] args) {
        Sql_test test = new Sql_test();
        test.main(2);

        Menu menu = new Menu();
        menu.Menu();



    }
}
