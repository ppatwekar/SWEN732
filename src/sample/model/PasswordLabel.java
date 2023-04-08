package sample.model;

public class PasswordLabel {
    private String label;
    private String username;
    private String password;
    private String notes;

    /**
     * @param label label of the password item
     * @param username username associated with password
     * @param password password
     * @param notes notes can include url, any notes
     */
    public PasswordLabel(String label, String username, String password, String notes) {
        this.label = label;
        this.username = username;
        this.password = password;
        this.notes = notes;
    }


    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
