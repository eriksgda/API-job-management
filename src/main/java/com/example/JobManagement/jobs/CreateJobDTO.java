package com.example.JobManagement.jobs;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobDTO {

    private String description;
    private String benefits;
    private String level;
}
