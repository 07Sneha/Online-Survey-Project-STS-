package com.example.online.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.online.model.CandidatePojo;
import com.example.online.model.SurveyPojo;
import com.example.online.repo.OnlineSurveyRepo;
import com.example.online.repo.SurveyPojoRepo;
@Service
public class CandidateServiceImp implements CandidateService {
	
	@Autowired
       OnlineSurveyRepo candidateRepo;
	@Autowired
	SurveyPojoRepo surveypojorepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		CandidatePojo candidate = candidateRepo.findByEmail(email);
        if (candidate == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(candidate.getAuthority()));

        return new User(candidate.getEmail(), candidate.getPassword(), authorities);
	}
       
	  @Override
	    public boolean isEmailExists(String email) {
	        return candidateRepo.existsByEmail(email);
	    }

	    @Override
	    public void saveCandidate(CandidatePojo candidate) {
	        candidateRepo.save(candidate);
	    }
	    
		@Override
		public CandidatePojo findById(Long id) {
			return candidateRepo.findById(id)
		            .orElseThrow(() -> new IllegalArgumentException("Invalid participant ID: " + id));
		}

		@Override
		public CandidatePojo getParticipantById(Long id) {
			return candidateRepo.findById(id)
		            .orElseThrow(() -> new IllegalArgumentException("Invalid participant ID: " + id));
		}

		@Override
		public void deleteById(Long id) {
			candidateRepo.deleteById(id);	
		}

		@Override
		public void saveParticipantAnswers(Long surveyId, String email, List<String> answers) {
			
			Optional<SurveyPojo> surveyOptional = surveypojorepo.findById(surveyId);
	        if (surveyOptional.isPresent()) {
	            SurveyPojo survey = surveyOptional.get();
	            SurveyPojo surveyAnswer = new SurveyPojo(survey, email, answers.get(0), answers.get(1),answers.get(2),answers.get(3));
	            surveypojorepo.save(surveyAnswer);
	         
		}
}
}
/*
Optional is a class in Java that was introduced to handle the possibility of having a
null value. It is used to represent an object that may or may not contain a non-null value.
This can help prevent null pointer exceptions and provide a more robust way of working with
potentially absent values.

Alternatively, you can use methods like orElse or orElseThrow to handle the absence of a 
value
     */
