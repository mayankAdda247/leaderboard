package com.mayank.userapi.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayank.userapi.entity.User;
import com.mayank.userapi.model.MessageResponse;
import com.mayank.userapi.repository.UserRepository;
import com.mayank.userapi.service.UserService;


@RestController
@RequestMapping
public class Controller {
	 @Autowired
	    private UserService userService;
	 /**
	     * Create a new USER by POST request, end point is http://hostname:port/api/va1/user
	     *
	     * @param user
	     * @return user
	     */
	    @PostMapping(value = "/user")
	    public ResponseEntity<?> createNewUser(@RequestBody User user) {
	        User createdUser = userService.saveUser(user);
	        return new ResponseEntity<Object>(createdUser, HttpStatus.CREATED);
	    }

	    /*** get a USER by ID in GET request, end point is http://hostname:port/api/va1/user/id
	     * @param userId
	     * @return
	     */

	    @GetMapping(value = "/user/{id}")
	    public ResponseEntity<?> getUserById(@PathVariable("id") Long userId) {
	        User user = userService.findUserById(userId);
	        if (user == null) {
	            MessageResponse messageResponse = new MessageResponse();
	            messageResponse.setMessage("User not found.");
	            return new ResponseEntity<Object>(messageResponse, HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Object>(user, HttpStatus.OK);
	    }

	    /**get all list of users based on GET request.
	     * @return
	     */

	    @GetMapping(value = "/user")
	    public ResponseEntity<?> getAllUsers() {
	        List<User> userList = userService.findAllUsers();
	        return new ResponseEntity<Object>(userList, HttpStatus.OK);
	    }

	    /**Update a user based on PUT request.
	     * @param userId
	     * @param user
	     * @return
	     */

	    @PutMapping(value = "/user/{id}")
	    public ResponseEntity<?> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
	        user.setId(userId);
	        User updatedUser = userService.updateUser(user);
	        return new ResponseEntity<Object>(updatedUser, HttpStatus.OK);
	    }

	    /**delete a user based on user ID.
	     * @param userId
	     * @return
	     */
	    @DeleteMapping(value = "/user/{id}")
	    public ResponseEntity<?> deleteUser(@PathVariable("id") Long userId) {
	        userService.deleteUser(userId);
	        MessageResponse messageResponse = new MessageResponse();
	        messageResponse.setMessage("User has been deleted successfully.");
	        return new ResponseEntity<Object>(messageResponse, HttpStatus.OK);
	    }
	}

