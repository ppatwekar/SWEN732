package sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSingleton {
    private Connection connection;
    private DBConnectionSingleton() throws SQLException {
        String username = "root";
        String password = "root@123";
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/password_manager",username,password);
    }

    public Connection getConnectionInstance() throws SQLException {
        if(this.connection == null){
            new DBConnectionSingleton();
        }
        return this.connection;
    }
}
