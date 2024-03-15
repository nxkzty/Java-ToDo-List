package bbcag.src.crud;
import java.sql.*;


public class DatabaseConnection {
    private String url;
    private String username;
    private String password;

    public DatabaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }


    public String getObjectById(int id) {
        String text = null;
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT text FROM todo_list WHERE todo_id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    text = resultSet.getString("text");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return text;
    }



    public void getAllObjects() {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM todo_list")) {

            while (resultSet.next()) {
                System.out.println((resultSet.getInt("todo_id") + ") " + resultSet.getString("text")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addNewToDo(String newText) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            String insertQuery = "INSERT INTO todo_list(text) values ('" + newText + "')";
            int rowsAffected = statement.executeUpdate(insertQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editToDo(int id, String updatedText) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            String insertQuery = "UPDATE todo_list SET text = '"+updatedText+"' WHERE todo_id = "+id;
            int rowsAffected = statement.executeUpdate(insertQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteToDo(int id) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            String deleteQuery = "DELETE FROM todo_list WHERE todo_id = " + id;
            int rowsAffected = statement.executeUpdate(deleteQuery);
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

}

