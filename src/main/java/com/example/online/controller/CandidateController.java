package com.example.online.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import com.example.online.service.CandidateService;

@Controller
@RequestMapping("/candidate")
public class CandidateController {

	 private CandidateService candidateService;
	
	 @PostMapping("/submit-survey/{surveyId}")
	    public String submitSurvey(@PathVariable Long surveyId, @RequestParam Map<String, String> answers) {
	        // Convert the answers map into a list of strings
	        List<String> answerList = new ArrayList<>();
	        for (int i = 1; i <= 4; i++) {
	            String answer = answers.get("question" + i);
	            answerList.add(answer);
	        }

	        // Get the authenticated user's email (participant's email)
	        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String email = auth.getName();

	        // Save the participant's answers
	        candidateService.saveParticipantAnswers(surveyId, email, answerList);

	        return "redirect:/candidate/home"; 
}
}