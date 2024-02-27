package mvc_app.mvc_app1;

import controler.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Classrooom {
    List<String> userNames = new ArrayList<>();
    List<String> univesities = new ArrayList<>();
    List<String> interests = new ArrayList<>();
    static Connection connection;
    public Classrooom() throws SQLException {
        connection = ConnectionManager.getConnection();
        String sql = "SELECT * FROM accounts";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            String username = resultSet.getString("username");
            String uni = resultSet.getString("university");
            String interest = resultSet.getString("interests");
            userNames.add(username);
            univesities.add(uni);
            interests.add(interest);
        }
    }
    public List<String> getUnivesities() {
        return univesities;
    }
    public List<String> getUserNames() {
        return userNames;
    }
    public List<String> getInterests() {
        return interests;
    }

}
