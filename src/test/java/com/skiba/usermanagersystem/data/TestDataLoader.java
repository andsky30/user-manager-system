package com.skiba.usermanagersystem.data;

import com.skiba.usermanagersystem.model.User;
import com.skiba.usermanagersystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Profile("test")
@RequiredArgsConstructor
public class TestDataLoader implements ApplicationRunner{

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    public void add2Users() {
        User user1 = new User("Jan", "pass1", "Jan", "Kowalski", LocalDate.of(2000, 01, 01));
        User user2 = new User("Janek", "pass2", "Jan", "Kowal", LocalDate.of(1999, 01, 01));
        userRepository.save(user1);
        userRepository.save(user2);
    }
}
