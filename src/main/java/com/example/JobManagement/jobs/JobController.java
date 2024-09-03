package com.example.JobManagement.jobs;

import com.example.JobManagement.company.CompanyEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private JobService service;

    @PostMapping("/")
    @PreAuthorize("hasHole('COMPANY')")
    public ResponseEntity<Object> createJob(@Valid @RequestBody CreateJobDTO jobDTO, HttpServletRequest request){
        try {
            Object companyId = request.getAttribute("company_id");
            JobEntity job = JobEntity.builder()
                    .companyId(UUID.fromString(companyId.toString()))
                    .benefits(jobDTO.getBenefits())
                    .description(jobDTO.getDescription())
                    .level(jobDTO.getLevel())
                    .build();

            this.service.createJob(job);

            return ResponseEntity.ok().body(job);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("error");
        }
    }
}
