package com.skiba.usermanagersystem.model;

import javax.persistence.Id;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
//@SqlResultSetMapping(
//        name = "UserMapping",
//        entities = {
//                @EntityResult(
//                        entityClass = User.class,
//                        fields = {
//                                @FieldResult(name = "id", column = "user_id"),
//                                @FieldResult(name = "userName", column = "user_name"),
//                                @FieldResult(name = "password", column = "password"),
//                                @FieldResult(name = "firstName", column = "first_name"),
//                                @FieldResult(name = "lastName", column = "last_name"),
//                                @FieldResult(name = "firstName", column = "first_name"),
//                                @FieldResult(name = "firstName", column = "first_name")})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
//            CascadeType.PERSIST,
//                    CascadeType.MERGE,
            })
    @JoinTable(
            name = "user_userGroups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<UserGroup> userGroups;

    public User() {
        userGroups = new ArrayList<>();
    }

    public User(String userName, String password,
                String firstName, String lastName, LocalDate dateOfBirth) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.userGroups = new ArrayList<>();
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

}
