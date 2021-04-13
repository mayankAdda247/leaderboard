package com.mayank.leaderboard.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.mayank.leaderboard.entity.Leaderboard;
import com.mayank.leaderboard.repository.LeaderboardRepo;

@Configuration
@EnableScheduling
public class config {
	
	@Autowired
	private  LeaderboardRepo repo;
	
	@Scheduled(fixedRate = 100000)
	public void scheduleFixedDelayTask() {
	 
		repo.deleteAll();
		repo.updateLeaderboard();
		System.out.println(" leaderboard updated successfully");
	}
			    
		
}
