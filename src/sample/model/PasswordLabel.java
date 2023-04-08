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

    /**
     *
     * @return the label name
     */
    public String getLabel() {
        return this.label;
    }

    /**
     *
     * @param label updates label name
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @return username associated with this label
     */
    public String getUsername() {
        return this.username;
    }

    /**
     *
     * @param username is used to update the username associated with this label
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return password associated with this label
     */
    public String getPassword() {
        return this.password;
    }

    /**
     *
     * @param password used to update password associated with this label
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return notes associated with this label
     */
    public String getNotes() {
        return this.notes;
    }

    /**
     *
     * @param notes used to update notes associated with this label
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
