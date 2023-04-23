package sample.dao.user;

import sample.dao.AbstractDatabaseDAO;
import sample.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAODatabase extends AbstractDatabaseDAO<Integer,User> implements UserDAO{

    protected UserDAODatabase() throws SQLException {
        super();
    }

    @Override
    public User getUserByEmail(String email) {
        User u = null;
        try {
            Statement s = this.connection.createStatement();
            String sql = "SELECT * FROM users WHERE email="+email+";";
            ResultSet resultSet = s.executeQuery(sql);
            while (resultSet.next()){
               String em = resultSet.getString("email");
               String masterPass = resultSet.getString("master_password");
               u = new User(em,masterPass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
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
