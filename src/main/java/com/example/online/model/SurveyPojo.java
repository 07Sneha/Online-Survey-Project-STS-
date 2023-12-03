package com.example.online.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "survey")
public class SurveyPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "survey_name", unique = true, nullable = false)
    private String surveyName;

    @Column(name = "survey_description")
    private String surveyDescription;
    
    @Column(name = "surveyed_by", nullable = false)
    private String surveyedBy;
    
    @Column(name = "participant_name", nullable = false)
    private String participantName;

    @Column(name = "question1")
    private String question1;

    @Column(name = "question2")
    private String question2;

	@Column(name = "question3")
    private String question3;

    @Column(name = "question4")
    private String question4;

    public SurveyPojo()
    {}
    SurveyPojo survey;
    public SurveyPojo(SurveyPojo survey,String participantName, String question1, String question2, String question3,
			String question4) {
		super();
		this.survey = survey;
	    this.participantName =participantName;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
	}
 
	public SurveyPojo(String surveyName, String surveyDescription,String surveyedBy,String participantName, String question1, String question2, String question3,
			String question4) {
		super();
		this.surveyName = surveyName;
		this.surveyDescription = surveyDescription;
		this.surveyedBy=surveyedBy;
	    this.participantName =participantName;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
	}
	
	
	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getSurveyDescription() {
		return surveyDescription;
	}

	public void setSurveyDescription(String surveyDescription) {
		this.surveyDescription = surveyDescription;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getQuestion4() {
		return question4;
	}

	public void setQuestion4(String question4) {
		this.question4 = question4;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    public String getSurveyedBy() {
		return surveyedBy;
	}

	public void setSurveyedBy(String surveyedBy) {
		this.surveyedBy = surveyedBy;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
}
