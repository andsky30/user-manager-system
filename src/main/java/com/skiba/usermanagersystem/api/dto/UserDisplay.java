package com.skiba.usermanagersystem.api.dto;

import java.util.List;

public class UserDisplay {

    private Long id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private List<UserGroupDisplayToJoin> userGroups;

    public UserDisplay() {
    }

    public UserDisplay(Long id, String userName, String password,
                       String firstName, String lastName, String dateOfBirth, List<UserGroupDisplayToJoin> userGroups) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.userGroups = userGroups;
    }

    public Long getId() {
        return id;
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

    public List<UserGroupDisplayToJoin> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroupDisplayToJoin> userGroups) {
        this.userGroups = userGroups;
    }
}
