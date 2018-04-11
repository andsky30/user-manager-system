package com.skiba.usermanagersystem.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyInGroupException extends RuntimeException {

    public static final String USER_ALREADY_IN_GROUP_MESSAGE = "User with ID: %d " +
            "is already member of group with ID: %d";

    public UserAlreadyInGroupException(Long userId, Long groupId) {
        super(String.format(USER_ALREADY_IN_GROUP_MESSAGE, userId, groupId));
    }
}
