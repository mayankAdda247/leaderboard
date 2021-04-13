package com.mayank.user_marks.service;

import java.util.List;

import com.mayank.user_marks.entity.Marks;

public interface MarksService {

		
	 Marks saveMarks (Marks marks);

	 Marks findMarksById(Long id);

	    List<Marks> findAllMarks();

	    Marks updateMarks(Marks marks);

	    String deleteMarks(Long id);
}
