package com.skiba.usermanagersystem.api.controller;

import com.skiba.usermanagersystem.api.dto.UserCreation;
import com.skiba.usermanagersystem.api.dto.UserDisplay;
import com.skiba.usermanagersystem.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    public static final String MESSAGE_AFTER_USER_BY_ID_DELETION = "User with ID: %d has been deleted successfully!!!";


    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/api/users")
    public ResponseEntity<List<UserDisplay>> getAllUsers() {
        List<UserDisplay> allUsers = userService.getAllUsers();

        return ResponseEntity.ok(allUsers);
    }

    @GetMapping(value = "/api/users/{userId}")
    public ResponseEntity<UserDisplay> getSingleUser(@PathVariable Long userId){

        UserDisplay singleUser = userService.getSingleUserById(userId);

        return ResponseEntity.ok(singleUser);
    }

    @PostMapping(value = "/api/users")
    public ResponseEntity<UserDisplay> addUser(@RequestBody UserCreation userCreation) {

        UserDisplay saved = userService.addUser(userCreation);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).body(saved);
    }

    @DeleteMapping(value = "/api/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){

        userService.removeUserById(userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(String.format(MESSAGE_AFTER_USER_BY_ID_DELETION, userId));
    }

}
