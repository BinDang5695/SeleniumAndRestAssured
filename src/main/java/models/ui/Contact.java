package models.ui;

public class Contact {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String file;
    private String blankPassword;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String email,
                   String password, String file, String blankPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.file = file;
        this.blankPassword = blankPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getBlankPassword() {
        return blankPassword;
    }

    public void setBlankPassword(String blankPassword) {
        this.blankPassword = blankPassword;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", file='" + file + '\'' +
                ", blankPassword='" + blankPassword + '\'' +
                '}';
    }
}