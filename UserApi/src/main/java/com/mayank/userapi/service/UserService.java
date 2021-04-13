package com.mayank.userapi.service;

import java.util.List;

import com.mayank.userapi.entity.User;

public interface UserService {
		
	  User saveUser(User user);

	    User findUserById(Long userId);

	    List<User> findAllUsers();

	    User updateUser(User user);

	    void deleteUser(Long userId);
}
