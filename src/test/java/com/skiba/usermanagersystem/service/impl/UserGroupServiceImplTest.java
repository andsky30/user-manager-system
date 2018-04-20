package com.skiba.usermanagersystem.service.impl;

import com.skiba.usermanagersystem.api.dto.UserDisplay;
import com.skiba.usermanagersystem.api.service.UserService;
import com.skiba.usermanagersystem.model.User;
import com.skiba.usermanagersystem.repository.UserRepository;
import com.skiba.usermanagersystem.service.mapper.UserCreationToUserMapper;
import com.skiba.usermanagersystem.service.mapper.UserToUserDisplayMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserGroupServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserToUserDisplayMapper userToUserDisplayMapper = new UserToUserDisplayMapper();
    private UserCreationToUserMapper userCreationToUserMapper = new UserCreationToUserMapper();

    @InjectMocks
    private UserService userService = new UserServiceImpl(userRepository,
            userToUserDisplayMapper, userCreationToUserMapper);

    @Before
    public void setUp(){
//        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnAllUsers() {
        //given
        List<User> users = new ArrayList<>();
        User user1 = new User("Jan", "pass1", "Jan", "Kowalski", LocalDate.of(2000, 01, 01));
        User user2 = new User("Jan", "pass1", "Jan", "Kowalski", LocalDate.of(2000, 01, 01));
        users.add(user1);
        users.add(user2);
        when(userRepository.findAll()).thenReturn(users);

        //when
        List<UserDisplay> allUsers = userService.getAllUsers();

        //then
        assertThat(allUsers).isNotNull();
        assertThat(allUsers).hasSize(2);

    }
}