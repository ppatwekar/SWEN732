package sample.dao.labeledPassword;

import sample.dao.AbstractDatabaseDAO;
import sample.dao.DAO;
import sample.dao.user.UserDAO;
import sample.dao.user.UserDAODatabase;
import sample.model.PasswordLabel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PasswordDAODatabase extends AbstractDatabaseDAO<Integer, PasswordLabel> implements PasswordTableDAO {

    private UserDAO userDAO;
    private static PasswordDAODatabase passwordDAODatabase;

    private PasswordDAODatabase() throws SQLException {
        super();
    }

    public static PasswordDAODatabase getInstance() throws SQLException {
        if(PasswordDAODatabase.passwordDAODatabase == null){
            PasswordDAODatabase.passwordDAODatabase = new PasswordDAODatabase();
        }
        return PasswordDAODatabase.passwordDAODatabase;
    }

    @Override
    public PasswordLabel createNew(PasswordLabel obj) {
        String sql = "INSERT INTO passwords(user_id, label, username, password, notes) VALUES(?,?,?,?,?)";
        return null;
    }

    @Override
    public PasswordLabel getObjectById(Integer id) {
        return null;
    }

    @Override
    public PasswordLabel updateObject(PasswordLabel obj) {
        return null;
    }

    @Override
    public PasswordLabel deleteObjectById(Integer id) {
        return null;
    }

    @Override
    public PasswordLabel deleteObject(PasswordLabel obj) {
        return null;
    }

    @Override
    public List<PasswordLabel> getAllPasswordLabelObjectsByUserId(Integer userId) {
        return null;
    }
}
