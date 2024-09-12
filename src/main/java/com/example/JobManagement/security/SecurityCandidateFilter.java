package com.example.JobManagement.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.JobManagement.security.providers.JWTCandidateProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class    SecurityCandidateFilter extends OncePerRequestFilter {

    @Autowired
    private JWTCandidateProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        if (request.getRequestURI().startsWith("/candidate") | request.getRequestURI().startsWith("/auth/candidate")){
            SecurityContextHolder.getContext().setAuthentication(null);
            String header = request.getHeader("Authorization");

            if (header != null){
                DecodedJWT token = this.jwtProvider.validateToken(header);

                if (token == null){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
                request.setAttribute("candidate_id", token.getSubject());
                List<Object> roles = token.getClaim("roles").asList(Object.class);

                List<SimpleGrantedAuthority> listGrants = roles.stream().map(
                        role -> new SimpleGrantedAuthority("ROLE_" + role.toString().toUpperCase())
                ).toList();
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        token.getSubject(),
                        null,
                        listGrants);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

        }

        filterChain.doFilter(request, response);
    }
}
