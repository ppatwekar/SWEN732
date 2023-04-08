package sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSingleton {
    private static Connection connection;
    private DBConnectionSingleton() throws SQLException {
        String username = "";
        String password = "";
        DBConnectionSingleton.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/password_manager",username,password);
    }

    /**
     * This will be used to give concrete daos access to MySQL database
     * @return Connection instance for the database
     * @throws SQLException
     */
    public static Connection getConnectionInstance() throws SQLException {
        if(DBConnectionSingleton.connection == null){
            new DBConnectionSingleton();
        }
        return DBConnectionSingleton.connection;
    }
}
