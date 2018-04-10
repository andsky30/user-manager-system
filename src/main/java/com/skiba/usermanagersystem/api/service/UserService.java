package com.skiba.usermanagersystem.api.service;

import com.skiba.usermanagersystem.api.dto.UserCreation;
import com.skiba.usermanagersystem.api.dto.UserDisplay;
import com.skiba.usermanagersystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<UserDisplay> getAllUsers();

//    User getSingleUser();
//
    UserDisplay addUser(UserCreation userCreation);
//
//    void removeUser(Long userId);
//
//    User updateUser(Long userId);

}
