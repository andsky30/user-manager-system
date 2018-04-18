package com.skiba.usermanagersystem.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserDisplay {

    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private List<UserGroupDisplayToJoin> userGroups;

}
