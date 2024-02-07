package com.Herukles.CVBuilder.Controllers;

import com.Herukles.CVBuilder.CV.Models.PersonalInformation;
import com.Herukles.CVBuilder.TestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class PersonalInfoControllerIT {
    private MockMvc mockMvc;

    @Test
    public void testThatPersonalInfoIsCreated() throws Exception
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        final PersonalInformation personalInformation = TestData.testPersonalInfo();
        final String personalInfoJson = objectMapper.writeValueAsString(personalInformation);
        mockMvc.perform(MockMvcRequestBuilders.put("/personalInfo/"+personalInformation.getId()).content("application/json")).andExpect(MockMvcResultMatchers.content().json(personalInfoJson));
    }
}
