package com.skiba.usermanagersystem.api.service;

import com.skiba.usermanagersystem.api.dto.UserGroupCreation;
import com.skiba.usermanagersystem.api.dto.UserGroupDisplay;
import com.skiba.usermanagersystem.model.UserGroup;

import java.util.List;

public interface UserGroupService {

    List<UserGroupDisplay> getAllGroups();

    UserGroupDisplay getSingleGroupById(Long groupId);

    UserGroupDisplay addUserGroup(UserGroupCreation userGroupCreation);

    void removeUserGroupById(Long groupId);

    UserGroupDisplay updateUserGroup(UserGroupCreation userGroupCreation, Long groupId);

    void addUserToGroup(Long groupId, Long userId);

    void removeUserFromGroup(Long groupId, Long userId);

    List<UserGroupDisplay> getAllGroupsPossibleToJoin(Long userId);

}
