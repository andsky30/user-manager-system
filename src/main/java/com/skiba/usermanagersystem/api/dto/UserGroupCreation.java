package com.skiba.usermanagersystem.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserGroupCreation {

    @NotBlank(message = "User group name cannot be empty or null!")
    private String name;
}
