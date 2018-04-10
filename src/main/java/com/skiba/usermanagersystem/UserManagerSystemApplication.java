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
public class UserManagerSystemApplication
		//implements CommandLineRunner
		{

//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private UserGroupRepository userGroupRepository;


	public static void main(String[] args) {
		SpringApplication.run(UserManagerSystemApplication.class, args);

	}

	/*


	@Transactional
	@Override
	public void run(String... args) throws Exception {

		//Cleanup the tables
		userRepository.deleteAllInBatch();
		userGroupRepository.deleteAllInBatch();

		//Create a user group
		UserGroup polesGroup = new UserGroup("Polish people");

		userGroupRepository.save(polesGroup);

		//Create 2 users
		User userAdam = new User("AMickiewicz",
				"pass1",
				"Adam",
				"Mickiewicz",
				LocalDate.of(1798, Month.DECEMBER, 24));

		User userHenryk = new User("HSienkiewicz",
				"pass2",
				"Henryk",
				"Sienkiewicz",
				LocalDate.of(1846,Month.MAY, 5));

		userRepository.save(userAdam);
		userRepository.save(userHenryk);

		//Add users to the group
		polesGroup.getUsers().add(userAdam);
		polesGroup.getUsers().add(userHenryk);

		//Add group references to the users
		userAdam.getUserGroups().add(polesGroup);
		userHenryk.getUserGroups().add(polesGroup);

		userGroupRepository.save(polesGroup);


		//Create a user group
		UserGroup longHairPeople = new UserGroup("Long Hair People");

		userGroupRepository.save(longHairPeople);

//		User userAdam = userRepository.findById(49L).get();
//		UserGroup longHairPeople = userGroupRepository.findById(51L).get();

		longHairPeople.getUsers().add(userAdam);
		userAdam.getUserGroups().add(longHairPeople);

		userGroupRepository.save(longHairPeople);

	}

		*/
}
