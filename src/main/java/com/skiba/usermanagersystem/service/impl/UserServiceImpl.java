package com.skiba.usermanagersystem.service.impl;

import com.skiba.usermanagersystem.api.dto.UserCreation;
import com.skiba.usermanagersystem.api.dto.UserDisplay;
import com.skiba.usermanagersystem.api.service.UserService;
import com.skiba.usermanagersystem.model.User;
import com.skiba.usermanagersystem.repository.UserRepository;
import com.skiba.usermanagersystem.service.exceptions.UserByIdNotFoundException;
import com.skiba.usermanagersystem.service.mapper.UserCreationToUserMapper;
import com.skiba.usermanagersystem.service.mapper.UserToUserDisplayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<UserDisplay> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userToUserDisplayMapper::map)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public UserDisplay getSingleUserById(Long userId) {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new UserByIdNotFoundException(userId);
        } else {
            return userToUserDisplayMapper.map(user);
        }
    }

    @Override
    public UserDisplay addUser(UserCreation userCreation) {
        User user = userCreationToUserMapper.map(userCreation);
        User savedUser = userRepository.save(user);

        return userToUserDisplayMapper.map(savedUser);
    }

    @Override
    public void removeUserById(Long userId) {

        User user = userRepository.findUserById(userId);

        if (user == null) {
            throw new UserByIdNotFoundException(userId);
        } else {
            userRepository.deleteById(userId);
        }
    }
}
