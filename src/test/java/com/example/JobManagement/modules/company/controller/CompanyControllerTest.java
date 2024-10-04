package com.example.JobManagement.modules.company.controller;

import com.example.JobManagement.company.CompanyEntity;
import com.example.JobManagement.company.CompanyRepository;
import com.example.JobManagement.jobs.CreateJobDTO;
import com.example.JobManagement.utils.UtilTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;

import static com.example.JobManagement.utils.UtilTest.toJson;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CompanyControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private CompanyRepository companyRepository;

    @BeforeEach
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    void testCreateJobReturnOk() throws Exception {

        CompanyEntity company = CompanyEntity.builder()
                .username("TEST_USERNAME")
                .name("TEST_NAME")
                .email("test@email.com")
                .password("1234567890")
                .description("TEST_DESCRIPTION")
                .build();

        company = this.companyRepository.saveAndFlush(company);

        CreateJobDTO newJob = CreateJobDTO.builder()
                .benefits("TEST_BENEFITS")
                .description("TEST_DESCRIPTION")
                .level("TEST_LEVEL").build();

        this.mvc.perform(MockMvcRequestBuilders.post("/company/job")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(newJob))
                .header("Authorization", UtilTest.generateToken(company.getId()))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
