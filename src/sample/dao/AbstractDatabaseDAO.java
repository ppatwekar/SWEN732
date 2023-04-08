package sample.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class AbstractDatabaseDAO {
    protected Connection connection;

    protected AbstractDatabaseDAO() throws SQLException {
        this.connection = DBConnectionSingleton.getConnectionInstance();
    }
}
