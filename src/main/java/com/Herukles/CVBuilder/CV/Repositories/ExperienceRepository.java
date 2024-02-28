package com.Herukles.CVBuilder.CV.Repositories;

import com.Herukles.CVBuilder.CV.Models.Entities.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long> {
}
