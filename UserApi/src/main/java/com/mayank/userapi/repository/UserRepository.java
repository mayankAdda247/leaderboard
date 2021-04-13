package com.mayank.userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayank.userapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
