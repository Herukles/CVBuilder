package com.Herukles.CVBuilder.Controllers;

import com.Herukles.CVBuilder.CV.Models.PersonalInformation;
import com.Herukles.CVBuilder.TestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
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

    @Test
    public void testThatPersonalInfoIsCreated() throws Exception
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        final PersonalInformation personalInformation = TestData.testPersonalInfo();
        final String personalInfoJson = objectMapper.writeValueAsString(personalInformation);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/CV/personalInfo/"+personalInformation.getId()).contentType(MediaType.APPLICATION_JSON)
                .content(personalInfoJson)).
                andExpect(MockMvcResultMatchers.jsonPath("$.id").value(personalInformation.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(personalInformation.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value(personalInformation.getSurname()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.countryOfBorn").value(personalInformation.getCountryOfBorn()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateOfBorn").value(personalInformation.getDateOfBorn().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(personalInformation.getAge()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.aboutMe").value(personalInformation.getAboutMe()));
    }
}
