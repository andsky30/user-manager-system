package com.skiba.usermanagersystem;

import com.skiba.usermanagersystem.model.User;
import com.skiba.usermanagersystem.model.UserGroup;
import com.skiba.usermanagersystem.repository.UserGroupRepository;
import com.skiba.usermanagersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
@EntityScan(basePackages = {"com.skiba.usermanagersystem.model"})
public class UserManagerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagerSystemApplication.class, args);
    }

}
