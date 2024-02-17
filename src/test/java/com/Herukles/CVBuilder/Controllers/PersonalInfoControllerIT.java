package com.Herukles.CVBuilder.Controllers;

import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Services.PersonalInfoService;
import com.Herukles.CVBuilder.TestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class PersonalInfoControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonalInfoService personalInfoService;

    @Test
    public void testThatPersonalInfoIsCreated() throws Exception
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        final PersonalInfo personalInfo = TestData.testPersonalInfo();
        final String personalInfoJson = objectMapper.writeValueAsString(personalInfo);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/CV/personalInfo/"+ personalInfo.getId()).contentType(MediaType.APPLICATION_JSON)
                .content(personalInfoJson)).
                andExpect(MockMvcResultMatchers.jsonPath("$.id").value(personalInfo.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(personalInfo.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value(personalInfo.getSurname()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.countryOfBorn").value(personalInfo.getCountryOfBorn()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateOfBorn").value(personalInfo.getDateOfBirth().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(personalInfo.getAge()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.aboutMe").value(personalInfo.getAboutMe()));
    }

    @Test
    public void testThatRetrievedPersonalInfoReturns404WhenPersonalNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/CV/personalInfo/9999999"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    @Test
    public void testThatRetrievedPersonalInfoReturnsHttp200AndPersonalWhenPersonalInfoExists() throws Exception{
        final PersonalInfo personalInfo = TestData.testPersonalInfo();
        personalInfoService.create(personalInfo);

        System.out.println("without toString"+ personalInfo.getDateOfBirth());
        System.out.println("with toString"+ personalInfo.getDateOfBirth().toString());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/CV/personalInfo/"+ personalInfo.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())

                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(personalInfo.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(personalInfo.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value(personalInfo.getSurname()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.countryOfBorn").value(personalInfo.getCountryOfBorn()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateOfBorn").value(personalInfo.getDateOfBirth().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(personalInfo.getAge()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.aboutMe").value(personalInfo.getAboutMe()));


                //1:00:50
    }
}

// 1:00:50
