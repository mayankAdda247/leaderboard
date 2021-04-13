package com.mayank.user_marks.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.user_marks.entity.Marks;
import com.mayank.user_marks.repository.MarksRepository;



@Transactional
@Service("userService")
public class MarksServiceImpl implements MarksService {
	
	@Autowired
	private MarksRepository marksRepository;
	
	@Override
	public Marks saveMarks(Marks marks) {
		// TODO Auto-generated method stub
		marksRepository.save(marks);
		return null;
	}

	@Override
	public Marks findMarksById(Long id) {
		// TODO Auto-generated method stub
		marksRepository.findById(id);
		
		Optional<Marks> userOptional = marksRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
		return null;
	}

	@Override
	public List<Marks> findAllMarks() {
		// TODO Auto-generated method stub
		return marksRepository.findAll();
		
	}

	@Override
	public Marks updateMarks(Marks marks) {
		// TODO Auto-generated method stub
		return marksRepository.save(marks);
		//return null;
	}

	@Override
	public String deleteMarks(Long id) {
		// TODO Auto-generated method stub
		
				marksRepository.deleteById(id);
				return "done!!";
		
	}

	

}
