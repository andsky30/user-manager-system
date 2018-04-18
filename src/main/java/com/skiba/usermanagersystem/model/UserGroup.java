package com.skiba.usermanagersystem.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_group")
@Getter @Setter
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    @Setter(AccessLevel.NONE)
    private Long id;
    @NotNull
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.MERGE,
            },
            mappedBy = "userGroups")
    private List<User> users;

    public UserGroup() {
        this.users = new ArrayList<>();
    }

    public UserGroup(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }
}
