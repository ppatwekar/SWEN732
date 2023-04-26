package sample.dao.user;

import sample.dao.DAO;
import sample.model.User;

public interface UserDAO extends DAO<Integer,User> {

    User getUserByEmail(String email);

    User deleteUser(String email);

}
