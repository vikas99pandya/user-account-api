package com.ing.dao;

import com.ing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring JPA repository for users
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
