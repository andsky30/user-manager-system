package com.skiba.usermanagersystem.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserGroupNotFoundException extends RuntimeException {

    public static final String USERGROUP_BY_ID_NOT_FOUND_MESSAGE = "Could not find " +
            "user group with id = %d.";

    public UserGroupNotFoundException(Long groupId) {
        super(String.format(USERGROUP_BY_ID_NOT_FOUND_MESSAGE, groupId));
    }
}
