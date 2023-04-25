package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import sample.dao.user.UserDAO;
import sample.dao.user.UserDAODatabase;
import sample.model.User;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable{
    private UserDAO userDAO;

    @FXML
    private Button registerButton;

    @FXML
    private Button closeButtonRegisterScreen;

    @FXML
    private PasswordField userPasswordTextField;

    @FXML
    private TextField userEmailTextField;

    @FXML private Label userAlreadyExists;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.userAlreadyExists.setText("");
        try {
            this.userDAO = new UserDAODatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void registerButtonOnAction(ActionEvent actionEvent) {
        String email = this.userEmailTextField.getText();
        String password = this.userPasswordTextField.getText();

        System.out.println(email+" "+password);

        if(!email.equals("") && !password.equals("")){
            if(this.userDAO.getUserByEmail(email) !=null){
                this.userAlreadyExists.setText("User Already Exists");
            }
            else{
                User u = new User(email, password);
                if(this.userDAO.createNew(u) != null){
                    this.userAlreadyExists.setText("Registered successfully!");
                }
                else{
                    this.userAlreadyExists.setText("User not registered!");
                }
            }
        }
    }

}
