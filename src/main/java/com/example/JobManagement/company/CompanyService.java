package com.example.JobManagement.company;

import com.example.JobManagement.exceptions.UserOrEmailAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private PasswordEncoder PasswordEncoder;

    public CompanyEntity createCompany(CompanyEntity company){
        if (this.repository.findByUsernameOrEmail(company.getUsername(), company.getEmail()) != null) {
            throw new UserOrEmailAlreadyExistException();
        }
        String encodedPassword = this.PasswordEncoder.encode(company.getPassword());
        company.setPassword(encodedPassword);

        return this.repository.save(company);
    }
}
