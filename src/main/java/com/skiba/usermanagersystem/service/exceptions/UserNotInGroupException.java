package com.skiba.usermanagersystem.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.skiba.usermanagersystem.util.Message.USER_NOT_IN_GROUP_MESSAGE;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotInGroupException extends RuntimeException {

    public UserNotInGroupException(Long userId, Long groupId) {
        super(String.format(USER_NOT_IN_GROUP_MESSAGE, userId, groupId));
    }
}
