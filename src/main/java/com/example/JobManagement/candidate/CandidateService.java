package com.example.JobManagement.candidate;

import com.example.JobManagement.exceptions.UserOrEmailAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository  repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity createUser(CandidateEntity candidate){
        if (this.repository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail()) != null){
            throw new UserOrEmailAlreadyExistException();
        }
        String encodedPassword = this.passwordEncoder.encode(candidate.getPassword());
        candidate.setPassword(encodedPassword);

        return this.repository.save(candidate);
    }
}
