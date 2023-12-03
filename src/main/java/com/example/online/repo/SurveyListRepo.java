package com.example.online.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online.model.SurveyListPojo;

public interface SurveyListRepo extends JpaRepository<SurveyListPojo, Long>  {

}
