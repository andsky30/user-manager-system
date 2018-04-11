package com.skiba.usermanagersystem.api.dto;

import java.util.List;

public class UserGroupDisplay {

    private Long id;

    private String name;

    private List<UserDisplay> users;

    public UserGroupDisplay() {
    }

    public UserGroupDisplay(Long id, String name, List<UserDisplay> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDisplay> getUsers() {
        return users;
    }

    public void setUsers(List<UserDisplay> users) {
        this.users = users;
    }
}
