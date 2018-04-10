package com.skiba.usermanagersystem.service.impl;

import com.skiba.usermanagersystem.api.dto.UserGroupCreation;
import com.skiba.usermanagersystem.api.dto.UserGroupDisplay;
import com.skiba.usermanagersystem.api.service.UserGroupService;
import com.skiba.usermanagersystem.model.UserGroup;
import com.skiba.usermanagersystem.repository.UserGroupRepository;
import com.skiba.usermanagersystem.service.exceptions.UserGroupNotFoundException;
import com.skiba.usermanagersystem.service.mapper.UserGroupCreationToUserGroupMapper;
import com.skiba.usermanagersystem.service.mapper.UserGroupToUserGroupDisplayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserGroupServiceImpl implements UserGroupService {

    UserGroupRepository userGroupRepository;
    UserGroupCreationToUserGroupMapper userGroupCreationToUserGroupMapper;
    UserGroupToUserGroupDisplayMapper userGroupToUserGroupDisplayMapper;

    @Autowired
    public UserGroupServiceImpl(UserGroupRepository userGroupRepository,
                                UserGroupCreationToUserGroupMapper userGroupCreationToUserGroupMapper,
                                UserGroupToUserGroupDisplayMapper userGroupToUserGroupDisplayMapper) {
        this.userGroupRepository = userGroupRepository;
        this.userGroupCreationToUserGroupMapper = userGroupCreationToUserGroupMapper;
        this.userGroupToUserGroupDisplayMapper = userGroupToUserGroupDisplayMapper;
    }

    @Override
    public List<UserGroupDisplay> getAllGroups() {
        return userGroupRepository.findAll().stream()
                .map(userGroupToUserGroupDisplayMapper::map)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public UserGroupDisplay getSingleGroupById(Long groupId) {
        UserGroup userGroup = userGroupRepository.findUserGroupById(groupId);
        if (userGroup == null) {
            throw new UserGroupNotFoundException(groupId);
        } else {
            return userGroupToUserGroupDisplayMapper.map(userGroup);
        }
    }

    @Override
    public UserGroupDisplay addUserGroup(UserGroupCreation userGroupCreation) {

        UserGroup userGroup = userGroupCreationToUserGroupMapper.map(userGroupCreation);

        UserGroup savedGroup = userGroupRepository.save(userGroup);

        return userGroupToUserGroupDisplayMapper.map(savedGroup);
    }

    @Override
    public void removeUserGroupById(Long groupId) {

        UserGroup userGroup = userGroupRepository.findUserGroupById(groupId);

        if (userGroup == null) {
            throw new UserGroupNotFoundException(groupId);
        } else {
            userGroupRepository.deleteById(groupId);
        }
    }

    @Override
    public UserGroupDisplay updateUserGroup(UserGroupCreation userGroupCreation, Long groupId) {
        UserGroup userGroup = userGroupRepository.findUserGroupById(groupId);

        if (userGroup == null) {
            throw new UserGroupNotFoundException(groupId);
        } else {

            userGroup.setName(userGroupCreation.getName());

            UserGroup savedGroup = userGroupRepository.save(userGroup);

            return userGroupToUserGroupDisplayMapper.map(savedGroup);
        }
    }
}
