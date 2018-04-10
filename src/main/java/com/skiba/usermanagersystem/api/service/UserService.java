package com.skiba.usermanagersystem.api.service;

import com.skiba.usermanagersystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

//    User getSingleUser();
//
//    User addUser(User user);
//
//    void removeUser(Long userId);
//
//    User updateUser(Long userId);

}
