package com.mayank.leaderboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayank.leaderboard.entity.Leaderboard;
import com.mayank.leaderboard.repository.LeaderboardRepo;

@EnableCaching
@RestController
@RequestMapping()
public class Controller {
	
	@Autowired
	private  LeaderboardRepo repo;

	@GetMapping("/leaderboard")
	public List<Leaderboard> findAllUsers() {
		return repo.getValues();
	}
	@PostMapping("/leaderboard")
	public List<Leaderboard> findAll() {
		repo.deleteAll();
		repo.updateLeaderboard();
		return repo.findAll();
	}
	
	
}
