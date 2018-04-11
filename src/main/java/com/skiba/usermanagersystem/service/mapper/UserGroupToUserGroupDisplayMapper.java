package com.skiba.usermanagersystem.service.mapper;

import com.skiba.usermanagersystem.api.dto.UserGroupDisplay;
import com.skiba.usermanagersystem.model.User;
import com.skiba.usermanagersystem.model.UserGroup;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class UserGroupToUserGroupDisplayMapper {

    private UserToUserDisplayMapper userToUserDisplayMapper = new UserToUserDisplayMapper();

    public UserGroupDisplay map(UserGroup userGroup) {

        return new UserGroupDisplay(
                userGroup.getId(),
                userGroup.getName(),
                userGroup.getUsers().stream()
                        .map(u -> userToUserDisplayMapper.map(u))
                        .collect(Collectors.toCollection(ArrayList::new))
        );
    }
}
