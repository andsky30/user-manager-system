package com.skiba.usermanagersystem.repository;

import com.skiba.usermanagersystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findUserById(Long userId);

}
