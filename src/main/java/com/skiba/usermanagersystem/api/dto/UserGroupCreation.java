package com.skiba.usermanagersystem.api.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class UserGroupCreation {

    @NotBlank(message = "User group name cannot be empty or null!")
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
