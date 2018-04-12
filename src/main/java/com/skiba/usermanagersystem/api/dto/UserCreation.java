package com.skiba.usermanagersystem.api.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

public class UserCreation {

    @NotBlank(message = "Username cannot be empty or null!")
    private String userName;
    @NotBlank(message = "Password cannot be empty or null!")
    private String password;
    @NotBlank(message = "First name cannot be empty or null!")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty or null!")
    private String lastName;
    @NotBlank(message = "Date of birth cannot be empty or null!")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Wrong date of birth format! Should be: yyy-MM-dd")
    private String dateOfBirth;

    public UserCreation() {
    }

    public UserCreation(Long id, String userName, String password,
                        String firstName, String lastName, String dateOfBirth) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
