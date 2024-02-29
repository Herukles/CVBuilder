package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Repositories.CVRepository;
import com.Herukles.CVBuilder.CV.Services.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.CVConverter.cvToCVEntity;
import static com.Herukles.CVBuilder.CV.Converters.CVConverter.cvEntityToCV;

@Service
public class CVServiceImpl implements CVService {

    CVRepository cvRepository;

    @Autowired
    public CVServiceImpl(CVRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @Override
    public String save(CV cv) {
        CVEntity cvEntity = cvToCVEntity(cv);
        cvRepository.save(cvEntity);
        return "saved successfully";
    }

    @Override
    public Optional<CV> findById(Long id) {
        Optional<CVEntity> foundCVEntity = cvRepository.findById(id);
        return foundCVEntity.map(cvEntity -> cvEntityToCV(cvEntity));
    }

    @Override
    public void deleteById(Long id) {
        cvRepository.deleteById(id);
    }


}
