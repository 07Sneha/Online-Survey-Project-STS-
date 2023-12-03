package com.example.online.service;

import java.util.List;
import com.example.online.model.SurveyListPojo;

public interface SurveyListService {

	void save(SurveyListPojo surveyListEntry);

	List<SurveyListPojo> getAllSurveys();

}
