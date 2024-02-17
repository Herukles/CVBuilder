package com.Herukles.CVBuilder.CV.Repository;

import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVRepository extends JpaRepository<CVEntity, Long> {
}
