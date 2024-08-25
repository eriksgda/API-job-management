package com.example.JobManagement.company;

import com.example.JobManagement.candidate.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    CompanyEntity findByUsernameOrEmail(String username, String email);
}
