package by.issue_tracker.model.dto;

import java.util.Objects;

public class UserSignUpDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String verifyPassword;

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

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSignUpDTO that = (UserSignUpDTO) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(verifyPassword, that.verifyPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password, verifyPassword);
    }

    @Override
    public String toString() {
        return "UserSignUpDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", verifyPassword='" + verifyPassword + '\'' +
                '}';
    }
}
