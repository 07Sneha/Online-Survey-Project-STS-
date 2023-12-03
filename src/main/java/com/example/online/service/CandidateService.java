package com.example.online.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.online.model.CandidatePojo;

public interface CandidateService extends UserDetailsService {

	boolean isEmailExists(String email);

	void saveCandidate(CandidatePojo candidate);

	CandidatePojo findById(Long id);

	CandidatePojo getParticipantById(Long id);

	void deleteById(Long id);

	void saveParticipantAnswers(Long surveyId, String email, List<String> answerList);


}
