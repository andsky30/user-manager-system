package com.skiba.usermanagersystem.api.controller;

import com.skiba.usermanagersystem.api.dto.UserGroupCreation;
import com.skiba.usermanagersystem.api.dto.UserGroupDisplay;
import com.skiba.usermanagersystem.api.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class UserGroupController {

    public static final String MESSAGE_AFTER_USERGROUP_BY_ID_DELETION = "User group " +
            "with ID: %d has been deleted successfully!!!";

    UserGroupService userGroupService;

    @Autowired
    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @GetMapping(value = "/api/groups")
    public ResponseEntity<List<UserGroupDisplay>> getAllGroups() {
        List<UserGroupDisplay> allGroups = userGroupService.getAllGroups();

        return ResponseEntity.ok(allGroups);
    }

    @GetMapping(value = "/api/groups/{groupId}")
    public ResponseEntity<UserGroupDisplay> getSingleGroup(@PathVariable Long groupId){

        UserGroupDisplay singleGroup = userGroupService.getSingleGroupById(groupId);

        return ResponseEntity.ok(singleGroup);
    }

    @PostMapping(value = "/api/groups")
    public ResponseEntity<UserGroupDisplay> addUserGroup(@RequestBody UserGroupCreation userGroupCreation) {

        UserGroupDisplay saved = userGroupService.addUserGroup(userGroupCreation);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).body(saved);
    }

    @DeleteMapping(value = "/api/groups/{groupId}")
    public ResponseEntity<String> deleteUserGroup(@PathVariable Long groupId){

        userGroupService.removeUserGroupById(groupId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(String.format(MESSAGE_AFTER_USERGROUP_BY_ID_DELETION, groupId));
    }
}
