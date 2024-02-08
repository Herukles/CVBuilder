package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.PersonalInformation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PersonalInfoService {

    PersonalInformation create(PersonalInformation personalInformation);
    Optional<PersonalInformation> findById(Long id);
}
