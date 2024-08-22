package com.example.JobManagement.candidate;

import com.example.JobManagement.exceptions.UserOrEmailAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository  repository;

    public CandidateEntity createUser(CandidateEntity candidate){
        if (this.repository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail()) != null){
            throw new UserOrEmailAlreadyExistException();
        }

        this.repository.save(candidate);
        return candidate;
    }
}
