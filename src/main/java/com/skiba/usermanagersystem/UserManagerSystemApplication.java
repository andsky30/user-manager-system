package com.skiba.usermanagersystem;

import com.skiba.usermanagersystem.model.User;
import com.skiba.usermanagersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan( basePackages = {"com.skiba.usermanagersystem.model"} )
public class UserManagerSystemApplication {


	public static void main(String[] args) {
		SpringApplication.run(UserManagerSystemApplication.class, args);




	}
}
