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
        String sql = "SELECT * FROM users WHERE email="+email+";";
        return this.getUserObjectBySingleUserStatement(sql);
    }

    @Override
    public User deleteUser(String email) {
        String sql = "DELETE FROM users WHERE email="+email+";";
        return this.getUserObjectBySingleUserStatement(sql);
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

    /**
     *
     * @param userResultSet ResultSet that contains only 1 user
     * @return User object from ResultSet
     * @throws SQLException yeah
     */
    private User getUserGivenResultSet(ResultSet userResultSet) throws SQLException {
        String em = userResultSet.getString("email");
        String masterPass = userResultSet.getString("master_password");

        return new User(em, masterPass);
    }

    /**
     * Can be used to get/update/create/delete a single user based on an sql statement
     * @param sql sql statement
     * @return User object
     */
    private User getUserObjectBySingleUserStatement(String sql){
        User u = null;
        try {
            Statement s = this.connection.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            u = this.getUserGivenResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
