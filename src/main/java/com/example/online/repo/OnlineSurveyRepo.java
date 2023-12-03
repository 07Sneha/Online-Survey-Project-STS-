package com.example.online.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.online.model.CandidatePojo;

@Repository
public interface OnlineSurveyRepo extends JpaRepository<CandidatePojo, Long>{

	CandidatePojo findByEmail(String email);

	boolean existsByEmail(String email);
}
