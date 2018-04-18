package com.skiba.usermanagersystem.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserCreation {

    @NotBlank(message = "Username cannot be empty or null!")
    private String userName;
    @NotBlank(message = "Password cannot be empty or null!")
    private String password;
    @NotBlank(message = "First name cannot be empty or null!")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty or null!")
    private String lastName;
    @NotBlank(message = "Date of birth cannot be empty or null!")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Wrong date of birth format! Should be: yyy-MM-dd")
    private String dateOfBirth;

}
