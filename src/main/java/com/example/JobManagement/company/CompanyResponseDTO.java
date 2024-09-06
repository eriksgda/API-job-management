package com.example.JobManagement.company;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponseDTO {
    private String username;
    private String name;
    private String email;
    private String website;
    private String description;
}
