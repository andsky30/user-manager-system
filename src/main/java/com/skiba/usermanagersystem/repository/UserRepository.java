package com.skiba.usermanagersystem.repository;

import com.skiba.usermanagersystem.api.dto.UserDisplay;
import com.skiba.usermanagersystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long userId);

    @Query(value = "SELECT * FROM User as u where u.user_id NOT IN (SELECT uug.user_id FROM user_user_groups as uug WHERE uug.group_id = ?1)", nativeQuery = true)
    List<User> findAllUsersPossibleToAddToGroup(String groupId);

//    @Query(value = "SELECT u FROM User u where u.id <> :group_id")
//    List<User> findAllUsersPossibleToAddToGroup(@Param("group_id") Long groupId);

}
