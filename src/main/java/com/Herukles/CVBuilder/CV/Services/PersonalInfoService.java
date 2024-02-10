package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PersonalInfoService {

    PersonalInfo create(PersonalInfo personalInfo);
    Optional<PersonalInfo> findById(Long id);

    List<PersonalInfo> getPersonalInfos();
}
