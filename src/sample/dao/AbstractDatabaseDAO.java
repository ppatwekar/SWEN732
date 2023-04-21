package sample.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDatabaseDAO<K,T> implements DAO<K,T>{
    protected Connection connection;

    protected AbstractDatabaseDAO() throws SQLException {
        this.connection = DBConnectionSingleton.getConnectionInstance();
    }
}
