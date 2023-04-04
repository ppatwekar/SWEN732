package sample.dao;

import java.sql.*;

public class TestDAO {
    public static void main(String[] args) throws SQLException {
        connectToDB();
    }

    public static void connectToDB() throws SQLException {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/record_company","","");
        Statement statement = myConn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM albums");

        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
    }
}
