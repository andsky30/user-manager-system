package com.skiba.usermanagersystem.service.impl;

import com.skiba.usermanagersystem.api.dto.UserCreation;
import com.skiba.usermanagersystem.api.dto.UserDisplay;
import com.skiba.usermanagersystem.api.service.UserService;
import com.skiba.usermanagersystem.model.User;
import com.skiba.usermanagersystem.repository.UserRepository;
import com.skiba.usermanagersystem.service.exceptions.UserNotFoundException;
import com.skiba.usermanagersystem.service.mapper.UserCreationToUserMapper;
import com.skiba.usermanagersystem.service.mapper.UserToUserDisplayMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.skiba.usermanagersystem.service.mapper.UserToUserDisplayMapper.BIRTHDAY_DATE_FORMATTER;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToUserDisplayMapper userToUserDisplayMapper;
    private final UserCreationToUserMapper userCreationToUserMapper;

    @Override
    public List<UserDisplay> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userToUserDisplayMapper::map)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public UserDisplay getSingleUserById(Long userId) {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
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
            throw new UserNotFoundException(userId);
        } else {
            userRepository.deleteById(userId);
        }
    }

    @Override
    public UserDisplay updateUser(UserCreation userCreation, Long userId) {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        } else {
            LocalDate updatedDateOfBirth = LocalDate.parse(userCreation.getDateOfBirth(),
                    BIRTHDAY_DATE_FORMATTER);
            user.setUserName(userCreation.getUserName());
            user.setPassword(userCreation.getPassword());
            user.setFirstName(userCreation.getFirstName());
            user.setLastName(userCreation.getLastName());
            user.setDateOfBirth(updatedDateOfBirth);
            User savedUser = userRepository.save(user);
            return userToUserDisplayMapper.map(savedUser);
        }
    }

    @Override
    public List<UserDisplay> getAllUsersPossibleToAddToGroup(Long groupId) {
        String grId = groupId.toString();
        return userRepository.findAllUsersPossibleToAddToGroup(grId).stream()
                .map(userToUserDisplayMapper::map)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
