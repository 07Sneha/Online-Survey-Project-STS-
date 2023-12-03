package com.example.online.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online.model.SurveyPojo;

public interface SurveyPojoRepo extends JpaRepository<SurveyPojo, Long>{

}
