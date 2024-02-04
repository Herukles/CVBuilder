package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.PersonalInformation;
import org.springframework.stereotype.Service;

@Service
public interface PersonalInfoService {

    PersonalInformation create(PersonalInformation personalInformation);
}
