package com.example.JobManagement.candidate;

import com.example.JobManagement.exceptions.UserOrEmailAlreadyExistException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService service;

    @PostMapping("/")
    public ResponseEntity<Object> createCandidate(@Valid @RequestBody CandidateEntity candidate){
        try{
            CandidateEntity result =  this.service.createUser(candidate);
            return ResponseEntity.ok().body(result);
        }catch(UserOrEmailAlreadyExistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
