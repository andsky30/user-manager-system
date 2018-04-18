package com.skiba.usermanagersystem.util;

public class Message {

    //controllers
    public static final String MESSAGE_AFTER_USER_BY_ID_DELETION = "User with ID: %d has been deleted successfully!!!";
    public static final String MESSAGE_AFTER_USERGROUP_BY_ID_DELETION = "User group " +
            "with ID: %d has been deleted successfully!!!";
    public static final String MESSAGE_AFTER_USER_TO_GROUP_ADDITION = "User  " +
            "with ID: %d has been added successfully to user group with ID: %d";
    public static final String MESSAGE_AFTER_USER_FROM_GROUP_DELETION = "User  " +
            "with ID: %d has been deleted successfully from user group with ID: %d";

    //exceptions
    public static final String USER_ALREADY_IN_GROUP_MESSAGE = "User with ID: %d " +
            "is already member of group with ID: %d";
    public static final String USERGROUP_BY_ID_NOT_FOUND_MESSAGE = "Could not find " +
            "user group with id = %d.";
    public static final String USER_BY_ID_NOT_FOUND_MESSAGE = "Could not find user with id = %d.";
    public static final String USER_NOT_IN_GROUP_MESSAGE = "User with ID: %d " +
            "is not member of group with ID: %d";
}
