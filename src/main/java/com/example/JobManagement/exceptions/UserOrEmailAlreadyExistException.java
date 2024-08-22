package com.example.JobManagement.exceptions;

public class UserOrEmailAlreadyExistException extends RuntimeException{
    public UserOrEmailAlreadyExistException(){
        super("Username or Email Already Exists.");
    }
}
