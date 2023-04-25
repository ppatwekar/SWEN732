package sample.dao.user;

import sample.dao.AbstractDatabaseDAO;
import sample.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAODatabase extends AbstractDatabaseDAO<Integer,User> implements UserDAO{

    public UserDAODatabase() throws SQLException {
        super();
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email='"+email+"';";
        return this.getUserObjectBySingleUserStatement(sql);
    }

    @Override
    public User deleteUser(String email) {
        String sql = "DELETE FROM users WHERE email="+email+";";
        return this.getUserObjectBySingleUserStatement(sql);
    }

    @Override
    public User createNew(User obj) {
        String sql = "INSERT INTO users(email, master_password) " +
                "VALUES "+String.format("(\"%s\", \"%s\");",obj.getEmail(),obj.getMaster_password());

        try {
            Statement s = this.connection.createStatement();
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return obj;
    }

    @Override
    public User getObjectById(Integer integer) {
        String sql = "SELECT * FROM users WHERE id="+integer+";";
        return this.getUserObjectBySingleUserStatement(sql);
    }

    @Override
    public User updateObject(User obj) {
        String sql = "UPDATE users SET master_password="+obj.getMaster_password()+" WHERE " +
                "email="+obj.getEmail()+";";
        return this.getUserObjectBySingleUserStatement(sql);
    }

    @Override
    public User deleteObjectById(Integer integer) {
        String sql = "DELETE FROM users WHERE id="+integer+";";
        return this.getUserObjectBySingleUserStatement(sql);
    }

    @Override
    public User deleteObject(User obj) {
        return this.deleteUser(obj.getEmail());
    }

    /**
     *
     * @param userResultSet ResultSet that contains only 1 user
     * @return User object from ResultSet
     * @throws SQLException yeah
     */
    private User getUserGivenResultSet(ResultSet userResultSet) throws SQLException {
        if(userResultSet.next()){
            String em = userResultSet.getString("email");
            String masterPass = userResultSet.getString("master_password");
            return new User(em, masterPass);
        }
        return null;
    }

    /**
     * Can be used to get/update/delete a single user based on an sql statement
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
