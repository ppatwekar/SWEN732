package sample.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    //email of user
    private String email;
    //master password of the user
    private String master_password;

    //passwords of the user
    private List<PasswordLabel> passwordLabelList;

    public User(){

    }

    /**
     *
     * @return list of labels along with their associated username, password and notes.
     */
    public List<PasswordLabel> getPasswordLabelList() {
        return passwordLabelList;
    }

    /**
     * Adds a new labelled password to the labelled passwords list
     * @param passwordLabel
     */
    public void addLabelledPassword(PasswordLabel passwordLabel){
        this.passwordLabelList.add(passwordLabel);
    }

    public User(String email, String master_password) {
        this.email = email;
        this.master_password = master_password;
        this.passwordLabelList = new ArrayList<>();
    }

    /**
     *
     * @return email of user
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email sets email of user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return master password of the user
     */
    public String getMaster_password() {
        return master_password;
    }

    /**
     *
     * @param master_password used to update the user's master password
     */
    public void setMaster_password(String master_password) {
        this.master_password = master_password;
    }
}
