package com.mayank.user_marks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="marks")
public class Marks {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column(name="id" ,unique=true, nullable=false)
	 	private Long id;
	 	
		@Column(name="user_id")
	  private Long userId;
	 	
	 	@Column(name="subject_id")
	  private Long subjectId;
	 	
	 	@Column(name="subject_name")
	  private String subjectName;
	 	
	  private Long  score;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}
	  
}

/*
  CREATE TABLE marks (id int, userid VARCHAR(20),
       species VARCHAR(20), sex CHAR(1), birth DATE, death DATE);*/
