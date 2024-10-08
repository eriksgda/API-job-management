package com.example.JobManagement.jobs;

import com.example.JobManagement.company.CompanyEntity;
import com.example.JobManagement.company.CompanyRepository;
import com.example.JobManagement.exceptions.CompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity createJob(JobEntity job) {
        Optional<CompanyEntity> company = this.companyRepository.findById(job.getCompanyId());
        if (company.isEmpty()){
            throw new CompanyNotFoundException();
        }

        return this.repository.save(job);
    }
}
