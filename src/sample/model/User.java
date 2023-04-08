package sample.model;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaster_password() {
        return master_password;
    }

    public void setMaster_password(String master_password) {
        this.master_password = master_password;
    }
}
