package sample.dao.user;

import sample.dao.AbstractDatabaseDAO;
import sample.model.User;

public class UserDAODatabase extends AbstractDatabaseDAO implements UserDAO{

    public UserDAODatabase(){
        super();
    }
    @Override
    public User createNewUser(User user) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(int id) {
        return null;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(String email) {
        return null;
    }
}
