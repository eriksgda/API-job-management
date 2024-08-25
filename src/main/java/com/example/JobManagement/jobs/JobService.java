package com.example.JobManagement.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public JobEntity createJob(JobEntity job) {
        this.repository.save(job);

        return job;
    }
}
