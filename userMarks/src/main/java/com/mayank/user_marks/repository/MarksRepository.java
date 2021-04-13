package com.mayank.user_marks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayank.user_marks.entity.Marks;

public interface MarksRepository extends JpaRepository<Marks, Long> {

}
