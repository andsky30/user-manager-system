package com.skiba.usermanagersystem.service.mapper;

import com.skiba.usermanagersystem.api.dto.UserGroupTransfer;
import com.skiba.usermanagersystem.api.dto.UserDisplay;
import com.skiba.usermanagersystem.model.User;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserToUserDisplayMapper {

    public static final DateTimeFormatter BIRTHDAY_DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    public static final String BIRTHDAY_DATE_PATTERN = "yyyy-MM-dd";

    public UserDisplay map(User user) {

        String dateOfBirth = user.getDateOfBirth().format(BIRTHDAY_DATE_FORMATTER);

        ArrayList<String> groupNames = user.getUserGroups().stream()
                .map(userGroup -> userGroup.getName())
                .collect(Collectors.toCollection(ArrayList::new));

        UserDisplay userDisplay = new UserDisplay(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                dateOfBirth,
                groupNames);

        return userDisplay;
    }
}
