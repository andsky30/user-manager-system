package com.skiba.usermanagersystem.api.service;

import com.skiba.usermanagersystem.model.UserGroup;

import java.util.List;

public interface UserGroupService {

    List<UserGroup> getAllUserGroups();

    UserGroup getSingleUserGroup();


}
