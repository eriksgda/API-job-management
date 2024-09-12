package com.example.JobManagement.configuration;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI(){

        return new OpenAPI()
                .info(new Info()
                .title("Cat Job Management")
                .description("API for job management *Only for Cats*")
                .version("1.0"))
                .schemaRequirement("jwt_auth", securityScheme());

                // ==== to authenticate every endpoint ====
                //.addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                //.components(new Components().addSecuritySchemes("Bearer Authentication", securityScheme()));
    }

    private SecurityScheme securityScheme(){
        return new SecurityScheme()
                .name("jwt_auth")
                .scheme("bearer")
                .bearerFormat("JWT")
                .type(SecurityScheme.Type.HTTP)
                .in(SecurityScheme.In.HEADER);
    }
}
