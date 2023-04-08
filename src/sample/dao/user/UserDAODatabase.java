package sample.dao.user;

import sample.dao.AbstractDatabaseDAO;
import sample.model.User;

import java.sql.SQLException;

public class UserDAODatabase extends AbstractDatabaseDAO implements UserDAO{

    protected UserDAODatabase() throws SQLException {
        super();
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User deleteUser(String email) {
        return null;
    }

    @Override
    public User createNew(User obj) {
        return null;
    }

    @Override
    public User getObjectById(Integer integer) {
        return null;
    }

    @Override
    public User updateObject(User obj) {
        return null;
    }

    @Override
    public User deleteObjectById(Integer integer) {
        return null;
    }

    @Override
    public User deleteObject(User obj) {
        return null;
    }
}
