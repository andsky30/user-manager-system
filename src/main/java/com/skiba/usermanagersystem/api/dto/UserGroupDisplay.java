package com.skiba.usermanagersystem.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserGroupDisplay {

    private Long id;
    private String name;
    private List<UserDisplay> users;

}
