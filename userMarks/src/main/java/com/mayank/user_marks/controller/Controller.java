package com.mayank.user_marks.controller;

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

import com.mayank.user_marks.entity.Marks;
import com.mayank.user_marks.service.MarksService;
import com.mayank.user_marks.model.MessageResponse;

@RestController
@RequestMapping
public class Controller {
	
	@Autowired
	private MarksService marksService;
	
	@PostMapping(value = "/marks")
    public ResponseEntity<?> createNewUser(@RequestBody Marks marks) {
        Marks createdMarks = marksService.saveMarks(marks);
        return new ResponseEntity<Object>(createdMarks, HttpStatus.CREATED);
    }
	 @GetMapping(value = "/marks/{id}")
	    public ResponseEntity<?> getMarksById(@PathVariable("id") Long id) {
	       Marks marks = marksService.findMarksById(id);
	        if (marks == null) {
	            MessageResponse messageResponse = new MessageResponse();
	            messageResponse.setMessage("User not found.");
	            return new ResponseEntity<Object>(messageResponse, HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Object>(marks, HttpStatus.OK);
	        
	 	}
	 @GetMapping(value = "/marks")
	    public ResponseEntity<?> getAllUsers() {
	        List<Marks> marksList = marksService.findAllMarks();
	        return new ResponseEntity<Object>(marksList, HttpStatus.OK);
	    }
	 @PutMapping(value = "/marks/{id}")
	    public ResponseEntity<?> updateMarks(@PathVariable("id") Long marksId, @RequestBody Marks marks) {
	        marks.setId(marksId);
	        Marks updatedMarks = marksService.updateMarks(marks);
	        return new ResponseEntity<Object>(updatedMarks, HttpStatus.OK);
	    }
	 @DeleteMapping(value = "/marks/{id}")
	    public ResponseEntity<?> deleteMarks(@PathVariable("id") Long userId) {
		 marksService.deleteMarks(userId);
	        MessageResponse messageResponse = new MessageResponse();
	        messageResponse.setMessage("UMarks  has been deleted successfully.");
	        return new ResponseEntity<Object>(messageResponse, HttpStatus.OK);
	    }
	 

	 
}
