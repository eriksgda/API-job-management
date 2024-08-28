package com.example.JobManagement.security;

import com.example.JobManagement.company.CompanyAuthDTO;
import com.example.JobManagement.company.CompanyAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class SecurityAuthController {

    @Autowired
    private CompanyAuthService companyAuthService;

    @PostMapping("/company")
    public ResponseEntity<Object> AuthenticateCompany(@RequestBody CompanyAuthDTO dto){
        try{
            String token = this.companyAuthService.authenticateCompany(dto);
            return ResponseEntity.ok().body(token);
        } catch (AuthenticationException exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
        }
    }
}
