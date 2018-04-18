package com.skiba.usermanagersystem.service.mapper;

import com.skiba.usermanagersystem.api.dto.UserGroupCreation;
import com.skiba.usermanagersystem.model.UserGroup;
import org.springframework.stereotype.Component;

@Component
public class UserGroupCreationToUserGroupMapper {

    public UserGroup map(UserGroupCreation userGroupCreation) {
        return new UserGroup(userGroupCreation.getName());
    }
}
