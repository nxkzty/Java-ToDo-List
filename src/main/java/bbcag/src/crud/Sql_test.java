package bbcag.src.crud;
import bbcag.src.crud.*;

public class Sql_test {
    DatabaseConnection database_test = new DatabaseConnection("jdbc:mysql://localhost:3306/database_todo", "root", "1234");

    public void main(int id) {
        System.out.println(database_test.getObjectById(id));
    }

    public void printAll() {
        database_test.getAllObjects();
    }
}
