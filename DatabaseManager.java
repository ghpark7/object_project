import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:learning_progress.db";

    public DatabaseManager() {
        createDatabase();
    }

    private void createDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS progress (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "topic TEXT," +
                         "status TEXT)";
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLearningProgress() {
        StringBuilder progress = new StringBuilder();
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM progress")) {
            while (resultSet.next()) {
                progress.append(resultSet.getInt("id")).append(". ")
                        .append(resultSet.getString("topic")).append(": ")
                        .append(resultSet.getString("status")).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return progress.toString();
    }

    public void updateLearningProgress(String topic, String status) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO progress (topic, status) VALUES ('" + topic + "', '" + status + "')";
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
