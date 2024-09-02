package com.example.JobManagement.candidate;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateAuthResponseDTO {

    private String access_token;
    private Long expired_in;
}
