package com.example.JobManagement.jobs;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService service;

    @PostMapping("/")
    public ResponseEntity<Object> createJob(@Valid @RequestBody JobEntity job){
        try {
            this.service.createJob(job);
            return ResponseEntity.ok().body(job);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("error");
        }
    }
}
