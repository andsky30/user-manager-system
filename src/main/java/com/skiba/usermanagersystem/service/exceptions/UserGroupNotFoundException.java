package com.skiba.usermanagersystem.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.skiba.usermanagersystem.util.Message.USERGROUP_BY_ID_NOT_FOUND_MESSAGE;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserGroupNotFoundException extends RuntimeException {

    public UserGroupNotFoundException(Long groupId) {
        super(String.format(USERGROUP_BY_ID_NOT_FOUND_MESSAGE, groupId));
    }
}
