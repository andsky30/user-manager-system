package com.skiba.usermanagersystem.service.mapper;

import com.skiba.usermanagersystem.api.dto.UserCreation;
import com.skiba.usermanagersystem.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.skiba.usermanagersystem.service.mapper.UserToUserDisplayMapper.BIRTHDAY_DATE_FORMATTER;

@Component
public class UserCreationToUserMapper {

    public User map(UserCreation userTransfer) {

        LocalDate dateOfBirth = LocalDate.parse(userTransfer.getDateOfBirth(),
                BIRTHDAY_DATE_FORMATTER);

        return new User(userTransfer.getUserName(),
                userTransfer.getPassword(),
                userTransfer.getFirstName(),
                userTransfer.getLastName(),
                dateOfBirth);
    }
}
