package com.example.online.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.online.model.SurveyPojo;
import com.example.online.repo.SurveyPojoRepo;

public class SurveyServiceImp implements SurveyService{

	 @Autowired
	    private SurveyPojoRepo surveyRepository;

	@Override
	public void save(SurveyPojo survey) {
		surveyRepository.save(survey);
	}

	@Override
	public void deleteSurveyById(Long id) {
		surveyRepository.deleteById(id);
		
	}
	
	
}
