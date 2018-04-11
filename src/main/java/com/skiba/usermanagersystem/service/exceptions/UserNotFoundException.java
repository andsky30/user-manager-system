package com.skiba.usermanagersystem.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public static final String USER_BY_ID_NOT_FOUND_MESSAGE = "Could not find user with id = %d.";

    public UserNotFoundException(Long userId) {
        super(String.format(USER_BY_ID_NOT_FOUND_MESSAGE, userId));
    }
}
