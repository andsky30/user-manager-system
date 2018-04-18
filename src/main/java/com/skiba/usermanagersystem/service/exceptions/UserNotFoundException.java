package com.skiba.usermanagersystem.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.skiba.usermanagersystem.util.Message.USER_BY_ID_NOT_FOUND_MESSAGE;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super(String.format(USER_BY_ID_NOT_FOUND_MESSAGE, userId));
    }
}
