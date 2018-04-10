package com.skiba.usermanagersystem.service.mapper;

import com.skiba.usermanagersystem.api.dto.UserGroupDisplay;
import com.skiba.usermanagersystem.model.User;
import com.skiba.usermanagersystem.model.UserGroup;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class UserGroupToUserGroupDisplayMapper {

    public UserGroupDisplay map(UserGroup userGroup) {

        return new UserGroupDisplay(
                userGroup.getId(),
                userGroup.getName(),
                userGroup.getUsers().stream()
                    .map(User::getUserName)
                    .collect(Collectors.toCollection(ArrayList::new))
        );
    }
}
