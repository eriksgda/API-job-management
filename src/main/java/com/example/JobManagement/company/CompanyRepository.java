package com.example.JobManagement.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    CompanyEntity findByUsernameOrEmail(String username, String email);
}
