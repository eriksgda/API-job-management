package com.example.JobManagement.exceptions;

public class JobNotFoundException extends RuntimeException{
    public JobNotFoundException() {
        super("Job not found.");
    }
}