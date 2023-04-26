package sample.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    //email of user
    private String email;
    //master password of the user
    private String master_password;



    public User(){

    }


    public User(String email, String master_password) {
        this.email = email;
        this.master_password = master_password;
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
