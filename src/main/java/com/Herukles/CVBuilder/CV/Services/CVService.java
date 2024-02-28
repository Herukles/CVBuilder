package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Entities.EducationEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface CVService {
    CV create(CV cv);
    Optional<CV> findById(Long id);
    List<CV> listOfCV();

//    void setEducationListById(@PathVariable long id, List<EducationEntity> educationEntities);
//    void addEducationToList(@PathVariable long id, EducationEntity educationEntity);
}
