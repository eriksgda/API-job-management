package com.example.JobManagement.company;

import com.example.JobManagement.exceptions.UserOrEmailAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public CompanyEntity createCompany(CompanyEntity company){
        if (this.repository.findByUsernameOrEmail(company.getUsername(), company.getEmail()) != null) {
            throw new UserOrEmailAlreadyExistException();
        }
        this.repository.save(company);

        return company;
    }
}
