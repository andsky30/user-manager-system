package com.skiba.usermanagersystem.repository;

import com.skiba.usermanagersystem.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

    UserGroup findUserGroupById(Long groupId);

    @Query(value = "SELECT * FROM user_group as ug where ug.group_id NOT IN (SELECT uug.group_id FROM user_user_groups as uug WHERE uug.user_id = ?1)", nativeQuery = true)
    List<UserGroup> findAllGroupsPossibleToJoin(String userId);
}
