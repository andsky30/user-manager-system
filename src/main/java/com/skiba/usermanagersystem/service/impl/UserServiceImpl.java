package com.skiba.usermanagersystem.service.impl;

import com.skiba.usermanagersystem.api.dto.UserCreation;
import com.skiba.usermanagersystem.api.dto.UserDisplay;
import com.skiba.usermanagersystem.api.service.UserService;
import com.skiba.usermanagersystem.model.User;
import com.skiba.usermanagersystem.repository.UserRepository;
import com.skiba.usermanagersystem.service.mapper.UserCreationToUserMapper;
import com.skiba.usermanagersystem.service.mapper.UserToUserDisplayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserToUserDisplayMapper userToUserDisplayMapper;
    UserCreationToUserMapper userCreationToUserMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserToUserDisplayMapper userToUserDisplayMapper,
                           UserCreationToUserMapper userCreationToUserMapper) {
        this.userRepository = userRepository;
        this.userToUserDisplayMapper = userToUserDisplayMapper;
        this.userCreationToUserMapper = userCreationToUserMapper;
    }

//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }

    @Override
    public UserDisplay addUser(UserCreation userCreation) {
        User user = userCreationToUserMapper.map(userCreation);
        User savedUser = userRepository.save(user);

        return userToUserDisplayMapper.map(savedUser);
    }

    @Override
    public List<UserDisplay> getAllUsers() {
        return null;
    }
}
