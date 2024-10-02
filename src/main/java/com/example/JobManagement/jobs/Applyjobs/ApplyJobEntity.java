package com.example.JobManagement.jobs.Applyjobs;

import com.example.JobManagement.candidate.CandidateEntity;
import com.example.JobManagement.jobs.JobEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "apply_jobs")
@Table(name = "apply_jobs")
public class ApplyJobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "candidate_id", insertable = false, updatable = false)
    private CandidateEntity candidate;

    @Column(name = "candidate_id")
    private UUID candidateId;

    @ManyToOne
    @JoinColumn(name = "job_id", insertable = false, updatable = false)
    private JobEntity job;

    @Column(name = "job_id")
    private UUID jobId;
}
