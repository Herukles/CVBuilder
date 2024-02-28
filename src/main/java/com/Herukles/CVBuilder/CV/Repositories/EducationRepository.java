package com.Herukles.CVBuilder.CV.Repositories;

import com.Herukles.CVBuilder.CV.Models.Entities.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<EducationEntity, Long> {
}
