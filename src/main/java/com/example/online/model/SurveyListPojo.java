package com.example.online.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "survey_list")
public class SurveyListPojo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String surveyName;

	@OneToOne
    @JoinColumn(name = "survey_id", referencedColumnName = "id")
    private SurveyPojo survey;
	
	public SurveyListPojo(String surveyName, SurveyPojo survey) {
		super();
		this.surveyName = surveyName;
		this.survey = survey;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public SurveyPojo getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyPojo survey) {
		this.survey = survey;
	}
}
/*look like this 
Table Name: survey_list

|   id   |  surveyName  |  survey_id  |
|--------|--------------|-------------|
|   1    |  Survey 1    |     101     |
|   2    |  Survey 2    |     102     |
|   3    |  Survey 3    |     103     |
|  ...   |     ...      |     ...     |
*/