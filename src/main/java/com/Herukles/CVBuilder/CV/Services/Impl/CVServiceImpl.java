package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Repositories.CVRepository;
import com.Herukles.CVBuilder.CV.Services.CVService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.CVConverter.cvToCVEntity;
import static com.Herukles.CVBuilder.CV.Converters.CVConverter.cvEntityToCV;

@Service
@Slf4j
public class CVServiceImpl implements CVService {

    CVRepository cvRepository;

    @Autowired
    public CVServiceImpl(CVRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @Override
    public CV save(CV cv) {
        CVEntity cvEntity = cvToCVEntity(cv);
        CVEntity savedCV = cvRepository.save(cvEntity);
        return cvEntityToCV(savedCV);
    }

    public List<CV> findAllCVs() {
        List<CVEntity> cvEntityList = cvRepository.findAll();
        return cvEntityList.stream().map(cvEntity -> cvEntityToCV(cvEntity)).toList();
    }

    @Override
    public Optional<CV> findById(Long id) {
        Optional<CVEntity> foundCVEntity = cvRepository.findById(id);
        return foundCVEntity.map(cvEntity -> cvEntityToCV(cvEntity));
    }

    @Override
    public void deleteById(Long id) {
        try {
            cvRepository.deleteById(id);
        } catch (final EmptyResultDataAccessException ex) {
            log.debug("Attempted to delete non-existent CV.");
        }
    }
}
