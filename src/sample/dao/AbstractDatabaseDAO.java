package sample.dao;

import sample.dao.DBConnectionSingleton;

import java.sql.Connection;
import java.sql.SQLException;

public class AbstractDatabaseDAO {
    protected Connection connection;
    protected AbstractDatabaseDAO(){
        try {
            this.connection = DBConnectionSingleton.getConnectionInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
