package sample.dao.user;

import sample.model.User;

public interface UserDAO {
    User createNewUser(User user);

    User getUserByEmail(String email);
    User getUserById(int id);

    User updateUser(User user);

    User deleteUser(int id);
    User deleteUser(User user);
    User deleteUser(String email);
}
