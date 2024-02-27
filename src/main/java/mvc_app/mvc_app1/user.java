package mvc_app.mvc_app1;

import controler.ConnectionManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

import java.sql.*;

public class user {
    private int id;
    private String username;
    private int age ;
    private String university;
    private String password;
    private String interests;
    static Connection connection;

    public user() {
        ConnectionManager.initializeConnectionPool();
        connection = ConnectionManager.getConnection();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public boolean loginUser(String username, String password) {
        boolean valid = false;
        try {
            String sql = "SELECT * FROM accounts WHERE username = ? AND password = ?";
            ResultSet resultSet = null;
            PreparedStatement statement = null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("authentification done");
                valid = true;
            } else {
                System.out.println("authentification error");
                valid = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }

    public void insertUser() {
        try {
            // Prepare the SQL statement
            String sql = "INSERT INTO accounts (username, password, age, university,interests) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set statement parameters
            statement.setString(1, this.getUsername());
            statement.setString(2, this.getPassword());
            statement.setInt(3, this.getAge());
            statement.setString(4, this.getUniversity());
            statement.setString(5, this.getInterests());

            // Execute the statement
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("No data inserted. Please check your query and data.");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}