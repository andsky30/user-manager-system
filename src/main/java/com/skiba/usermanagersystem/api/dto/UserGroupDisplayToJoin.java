package com.skiba.usermanagersystem.api.dto;

public class UserGroupDisplayToJoin {

    private Long id;

    private String name;

    public UserGroupDisplayToJoin() {
    }

    public UserGroupDisplayToJoin(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
