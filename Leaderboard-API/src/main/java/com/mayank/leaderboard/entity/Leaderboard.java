package com.mayank.leaderboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="leaderboard")
@RedisHash("Leaderboard")

public class Leaderboard {


		
		 	@Id
		  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name="user_id")
		  private Long userId;
		 	
			@Column(name="firstname")
		  private String firstName;
		 	
		 	@Column(name="lastname")
		  private String lastName;
		 	
		 private Long score;

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Long getScore() {
			return score;
		}

		public void setScore(Long score) {
			this.score = score;
		}
		  
		  
	 
	

}
