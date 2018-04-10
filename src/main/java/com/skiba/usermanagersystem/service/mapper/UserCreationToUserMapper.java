package com.skiba.usermanagersystem.service.mapper;

import com.skiba.usermanagersystem.api.dto.UserCreation;
import com.skiba.usermanagersystem.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.skiba.usermanagersystem.service.mapper.UserToUserDisplayMapper.BIRTHDAY_DATE_FORMATTER;

@Component
public class UserCreationToUserMapper {

    public User map(UserCreation userCreation) {

        LocalDate dateOfBirth = LocalDate.parse(userCreation.getDateOfBirth(),
                BIRTHDAY_DATE_FORMATTER);

        return new User(userCreation.getUserName(),
                userCreation.getPassword(),
                userCreation.getFirstName(),
                userCreation.getLastName(),
                dateOfBirth);
    }
}
