package com.example.ujianweb1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ujianweb1.entity.Curiculum;
import com.example.ujianweb1.repository.CuriculumRepository;

@Service
public class CuriculumService {

	@Autowired
	CuriculumRepository curiculumRepository;
	
	public Curiculum saveCuriculum( Curiculum curiculum) {
		return curiculumRepository.save(curiculum);
	}
}
