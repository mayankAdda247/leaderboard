package com.mayank.leaderboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.mayank.leaderboard.entity.Leaderboard;

public interface LeaderboardRepo extends JpaRepository<Leaderboard,Long > {
	@Query(value="SELECT u.id as user_id, u.firstname, u.lastname, SUM(m.score) AS score\n"
			+ "FROM user AS u\n"
			+ "JOIN marks AS m ON m.user_id = u.id\n"
			+ "GROUP BY u.id, u.firstName, u.lastName\n"
			+ "ORDER BY SUM(m.score) DESC;\n"
			+ "",nativeQuery=true)
	List<Leaderboard> getValues();
	
	@Transactional
	@Modifying
	@Query(value="Insert into leaderboard\n"
			+ "     SELECT u.id as user_id, u.firstName, u.lastName, SUM(m.score) AS TotalScore\n"
			+ "     FROM user AS u\n"
			+ "     JOIN marks AS m ON m.user_id = u.id\n"
			+ "     GROUP BY u.id, u.firstName, u.lastName\n"
			+ "     ORDER BY SUM(m.score) DESC\n"
			+ "     LIMIT 10;\n"
			+ "",nativeQuery=true)
	void updateLeaderboard();
	
}
 