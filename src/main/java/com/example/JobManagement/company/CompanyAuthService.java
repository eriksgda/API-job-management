package com.example.JobManagement.company;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class CompanyAuthService {

    @Value("$(security.token.secret.company)")
    private String secretKey;

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public CompanyAuthResponseDTO authenticateCompany(CompanyAuthDTO dto) throws AuthenticationException{
        CompanyEntity company = this.repository.findByUsername(dto.getUsername());
        if (company == null) {
            throw new UsernameNotFoundException("Username or Password Incorrect.");
        }

        boolean passwordMatches = this.encoder.matches(dto.getPassword(), company.getPassword());
        if (!passwordMatches){
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        Instant expiresIn = Instant.now().plus(Duration.ofHours(2));

        String token =  JWT.create()
                .withIssuer("company").withSubject(company.getId().toString())
                .withClaim("roles", List.of("COMPANY"))
                .withExpiresAt(expiresIn)
                .sign(algorithm);

        return CompanyAuthResponseDTO.builder()
                .access_token(token)
                .expired_at(expiresIn.toEpochMilli())
                .build();
    }

}
