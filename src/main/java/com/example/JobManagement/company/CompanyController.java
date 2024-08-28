package com.example.JobManagement.company;

import com.example.JobManagement.exceptions.UserOrEmailAlreadyExistException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @PostMapping("/")
    public ResponseEntity<Object> createCompany(@Valid @RequestBody CompanyEntity company){
        try {
            CompanyEntity result = this.service.createCompany(company);
            return ResponseEntity.ok().body(result);
        } catch (UserOrEmailAlreadyExistException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
