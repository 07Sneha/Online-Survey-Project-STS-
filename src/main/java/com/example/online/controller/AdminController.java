package com.example.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.online.model.CandidatePojo;
import com.example.online.model.SurveyListPojo;
import com.example.online.model.SurveyPojo;
import com.example.online.service.CandidateService;
import com.example.online.service.SurveyListService;
import com.example.online.service.SurveyService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	    @Autowired
	    private CandidateService candidateService;
	    
	    @Autowired
	    private SurveyService surveyService ;

	    @Autowired
	    private SurveyListService surveyListService ;
	    
	    @GetMapping("/add-participant")
	    public String showAddParticipantForm() {
	        return "add-participant";
	    }

	    @PostMapping("/add-participant")
	    public String addParticipant(@RequestParam String email, @RequestParam String firstName,
	    	    @RequestParam String lastName,@RequestParam String password,@RequestParam String authority,
	    	    @RequestParam int priority ) {
	        // Check if email already exists
	        if (candidateService.isEmailExists(email)) {
	            return "redirect:/admin/add-participant?duplicate=true";
	        }
	        // Create and save participant
	        CandidatePojo participant = new CandidatePojo(firstName, lastName, email, password, priority, authority);
	        candidateService.saveCandidate(participant);

	        // Redirect back to participant list or other appropriate page
	        return "redirect:/admin/participant-list";
	    }
	    
	    
	    @GetMapping("/update-participant/{id}")
		public String showUpdateParticipantForm(@PathVariable Long id, Model model) 
	    {
	    	 try {	 // Retrieve the participant by ID using the CandidateService
	    	        CandidatePojo participant = candidateService.getParticipantById(id);

	    	        // Pass the participant object to the update form
	    	        model.addAttribute("participant", participant);

	    	        return "update-participant"; // The name of the Thymeleaf template for the update form
	    	    } catch (IllegalArgumentException e) {
	    	        // Handle the case where the participant was not found
	    	        return "error-page";
		        }
	        }
	    
	    @PostMapping("/delete-participant/{id}")
	    public String deleteParticipant(@PathVariable Long id) {
	        candidateService.deleteById(id);
	        return "redirect:/participant-list"; // Redirect to the participant list page after deletion
	    }

	//creating survey table code
	    
	    @PostMapping("/add-survey")
	    public String addSurvey(@RequestParam String surveyName,
	                            @RequestParam String surveyDescription,
	                            @RequestParam String surveyedBy,
	                            @RequestParam String participantName,
	                            @RequestParam String q1,
	                            @RequestParam String q2,
	                            @RequestParam String q3,
	                            @RequestParam String q4
	                            ) {
	        // Create a new SurveyPojo instance and set the attributes
	        SurveyPojo survey = new SurveyPojo(surveyName,surveyDescription,surveyedBy,participantName,q1,q2,q3,q4);
	       

	        // Save the survey to the database
	        surveyService.save(survey);

	        SurveyListPojo surveyListEntry = new SurveyListPojo(surveyName, survey);
	        
	        surveyListService.save(surveyListEntry);

	        
	        // Redirect to a success page or another page
	        return "redirect:/admin/home"; // Redirect back to admin home page
	    }
	    
	    
	 // Mapping for the View Survey page
	    @GetMapping("/view-survey")
	    public String viewSurveys(Model model) {
	        List<SurveyListPojo> surveys = surveyListService.getAllSurveys();
	        model.addAttribute("surveys", surveys);
	        return "view-survey"; // Thymeleaf template name
	    }

	    // Mapping to delete a survey by its ID
	    @PostMapping("/delete-survey/{id}")
	    public String deleteSurvey(@PathVariable Long id) {
	        // Delete the survey and associated entries
	        surveyService.deleteSurveyById(id);
	        return "redirect:/admin/view-survey";
	    }
	}
	    
	    
