package com.opeyemi.fieldvalidationone;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank(message = "First Name field cannot be blank")
    @Size(min = 3, message = "First Name is too short")
    private String firstName;
    @NotBlank(message = "Last Name field cannot be blank")
    private String lastName;
    @NotBlank(message = "Username field cannot be blank")
    private String userName;
    @Email(message = "You must enter a valid email address")
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date of birth must not be in the past")
    private Date dateOfBirth;

    
    public User() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", userName='" + getUserName() + "'" +
            ", email='" + getEmail() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            "}";
    }


}
