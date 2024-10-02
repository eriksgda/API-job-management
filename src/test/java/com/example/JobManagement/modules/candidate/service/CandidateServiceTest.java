package com.example.JobManagement.modules.candidate.service;

import com.example.JobManagement.candidate.CandidateEntity;
import com.example.JobManagement.candidate.CandidateRepository;
import com.example.JobManagement.candidate.CandidateService;
import com.example.JobManagement.exceptions.JobNotFoundException;
import com.example.JobManagement.exceptions.UserNotFoundException;
import com.example.JobManagement.jobs.JobRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

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

    @Test
    @DisplayName("Apply job should return job not found exception if job don't exists.")
    void testApplyJobReturnJobNotFound(){
        UUID candidateId = UUID.randomUUID();
        CandidateEntity candidate = new CandidateEntity();
        candidate.setId(candidateId);

        when(candidateRepository.findById(candidateId)).thenReturn(Optional.of(candidate));
        Assertions.assertThrows(JobNotFoundException.class,
                () -> service.applyJob(candidateId, null));
    }
}
