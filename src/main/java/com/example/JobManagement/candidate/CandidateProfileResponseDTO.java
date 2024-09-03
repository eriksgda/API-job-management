package com.example.JobManagement.candidate;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateProfileResponseDTO {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String description;
}
