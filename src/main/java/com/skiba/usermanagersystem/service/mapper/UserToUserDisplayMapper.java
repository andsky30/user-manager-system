package com.skiba.usermanagersystem.service.mapper;

import com.skiba.usermanagersystem.api.dto.UserDisplay;
import com.skiba.usermanagersystem.model.User;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class UserToUserDisplayMapper {

    public static final DateTimeFormatter BIRTHDAY_DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    private UserGroupToUserGroupDisplayToJoinMapper userGroupToUserGroupDisplayToJoinMapper =
            new UserGroupToUserGroupDisplayToJoinMapper();

    public UserDisplay map(User user) {
        String dateOfBirth = user.getDateOfBirth().format(BIRTHDAY_DATE_FORMATTER);
        UserDisplay userDisplay = new UserDisplay(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                dateOfBirth,
                user.getUserGroups().stream()
                    .map(g -> userGroupToUserGroupDisplayToJoinMapper.map(g))
                    .collect(Collectors.toCollection(ArrayList::new)));
        return userDisplay;
    }
}
