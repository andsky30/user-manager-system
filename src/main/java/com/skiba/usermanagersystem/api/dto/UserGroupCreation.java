package com.skiba.usermanagersystem.api.dto;

import java.util.List;

public class UserGroupCreation {

    private String name;

    public UserGroupCreation() {
    }

    public UserGroupCreation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
