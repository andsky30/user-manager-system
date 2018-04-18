package com.skiba.usermanagersystem.service.mapper;

import com.skiba.usermanagersystem.api.dto.UserGroupDisplay;
import com.skiba.usermanagersystem.api.dto.UserGroupDisplayToJoin;
import com.skiba.usermanagersystem.model.UserGroup;
import org.springframework.stereotype.Component;

@Component
public class UserGroupToUserGroupDisplayToJoinMapper {

    public UserGroupDisplayToJoin map(UserGroup userGroup) {
        UserGroupDisplayToJoin userGroupDisplayToJoin = new UserGroupDisplayToJoin(
                userGroup.getId(),
                userGroup.getName());
        return userGroupDisplayToJoin;
    }
}
