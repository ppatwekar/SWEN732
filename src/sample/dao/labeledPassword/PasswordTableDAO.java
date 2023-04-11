package sample.dao.labeledPassword;

import sample.dao.DAO;
import sample.model.PasswordLabel;

import java.util.List;

public interface PasswordTableDAO extends DAO<Integer, PasswordLabel> {
    List<PasswordLabel> getAllPasswordLabelObjectsByUserId(Integer userId);

}
