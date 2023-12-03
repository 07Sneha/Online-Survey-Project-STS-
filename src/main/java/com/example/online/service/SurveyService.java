package com.example.online.service;

import com.example.online.model.SurveyPojo;

public interface SurveyService {

	void save(SurveyPojo survey);

	void deleteSurveyById(Long id);
   
}
