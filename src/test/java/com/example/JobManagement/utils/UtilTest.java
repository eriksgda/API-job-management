package com.example.JobManagement.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;

public class UtilTest {

    private static final String COMPANY_SECRET_KEY = "company_3572901568@#(&!#yfwerei43720!@#&)(@$hew3(@H$@rh3287y";
    private static final String WRONG_SECRET_KEY = "wrong_3&572901568#(&!#yfwyeei43720!@#&)(@$hew3(@H$@0h3287y";

    public static String toJson(Object object){
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch(Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String generateToken(UUID companyId){

        Algorithm algorithm = Algorithm.HMAC256(COMPANY_SECRET_KEY);
        Instant expiresIn = Instant.now().plus(Duration.ofHours(2));
        String token =  JWT.create()
                .withIssuer("company").withSubject(companyId.toString())
                .withClaim("roles", Arrays.asList("COMPANY"))
                .withExpiresAt(expiresIn)
                .sign(algorithm);

        return token;
    }

    public static String generateWrongToken(UUID companyId){

        Algorithm algorithm = Algorithm.HMAC256(WRONG_SECRET_KEY);
        Instant expiresIn = Instant.now().plus(Duration.ofHours(2));
        String token =  JWT.create()
                .withIssuer("company").withSubject(companyId.toString())
                .withClaim("roles", Arrays.asList("COMPANY"))
                .withExpiresAt(expiresIn)
                .sign(algorithm);

        return token;
    }
}
