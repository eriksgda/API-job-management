package com.example.JobManagement.company;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyAuthResponseDTO {

    private String access_token;
    private Long expired_at;

}
