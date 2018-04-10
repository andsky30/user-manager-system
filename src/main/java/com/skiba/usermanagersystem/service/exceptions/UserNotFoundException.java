package com.skiba.usermanagersystem.service.exceptions;

public class UserNotFoundException extends RuntimeException {

    public static final String USER_BY_ID_NOT_FOUND_MESSAGE = "Could not find user with id = %d.";

    public UserNotFoundException(Long userId) {
        super(String.format(USER_BY_ID_NOT_FOUND_MESSAGE, userId));
    }
}