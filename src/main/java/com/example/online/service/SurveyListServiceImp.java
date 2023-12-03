 package com.example.online.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.online.model.SurveyListPojo;
import com.example.online.repo.SurveyListRepo;

public class SurveyListServiceImp implements SurveyListService {
 
	@Autowired
	SurveyListRepo surveyListrepo;
	
	@Override
	public void save(SurveyListPojo surveyListEntry) {
		surveyListrepo.save(surveyListEntry);
		
	}

	@Override
	public List<SurveyListPojo> getAllSurveys() {
		 return surveyListrepo.findAll();
	}

	

}
