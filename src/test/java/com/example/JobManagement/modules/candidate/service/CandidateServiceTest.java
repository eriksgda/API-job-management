package com.example.JobManagement.modules.candidate.service;

import com.example.JobManagement.candidate.CandidateRepository;
import com.example.JobManagement.candidate.CandidateService;
import com.example.JobManagement.exceptions.UserNotFoundException;
import com.example.JobManagement.jobs.JobRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CandidateServiceTest {

    @InjectMocks
    public CandidateService service;

    @Mock
    public CandidateRepository candidateRepository;

    @Mock
    public JobRepository jobRepository;

    @Test
    @DisplayName("Apply job should return user not found exception if candidate don't exists.")
    void testApplyJobReturnCandidateNotFound(){
        Assertions.assertThrows(UserNotFoundException.class,
                () -> service.applyJob(null, null));
    }
}
