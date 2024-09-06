package com.example.JobManagement.candidate;

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
public class CandidateAuthService {

    @Value("${security.token.secret.candidate}")
    private String secretKey;

    @Autowired
    private CandidateRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateAuthResponseDTO authenticateCandidate(CandidateAuthDTO dto) throws AuthenticationException {
        CandidateEntity candidate = this.repository.findByUsername(dto.username());
        if(candidate == null){
            throw new UsernameNotFoundException("Username or Password Incorrect.");
        }

        boolean passwordMatches = this.passwordEncoder.matches(dto.password(), candidate.getPassword());
        if(!passwordMatches){
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Instant expiresIn = Instant.now().plus(Duration.ofHours(2));
        String token = JWT.create()
                .withIssuer("candidate").withSubject(candidate.getId().toString())
                .withClaim("roles", List.of("CANDIDATE"))
                .withExpiresAt(expiresIn)
                .sign(algorithm);

        return CandidateAuthResponseDTO.builder()
                .access_token(token)
                .expired_in(expiresIn.toEpochMilli())
                .build();
    }
}
