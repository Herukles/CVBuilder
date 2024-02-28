package com.Herukles.CVBuilder.CV.Repositories;

import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepository extends JpaRepository<CVEntity, Long> {
}
