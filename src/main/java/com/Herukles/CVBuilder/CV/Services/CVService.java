package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.CV;

import java.util.List;
import java.util.Optional;

public interface CVService {
    CV create(CV cv);
    Optional<CV> findById(Long id);
    List<CV> listOfCV();
}
