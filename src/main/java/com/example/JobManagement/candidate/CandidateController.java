package com.example.JobManagement.candidate;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository  repository;

    @PostMapping("/")
    public CandidateEntity createCandidate(@Valid @RequestBody CandidateEntity candidate){
        return this.repository.save(candidate);
    }
}
