package com.skiba.usermanagersystem.model;

import javax.persistence.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_group")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "userGroups")
    private List<User> users;


}
