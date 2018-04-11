package com.skiba.usermanagersystem.service.exceptions;

public class UserNotInGroupException extends RuntimeException {

    public static final String USER_NOT_IN_GROUP_MESSAGE = "User with ID: %d " +
            "is not member of group with ID: %d";

    public UserNotInGroupException(Long userId, Long groupId) {
        super(String.format(USER_NOT_IN_GROUP_MESSAGE, userId, groupId));
    }
}
