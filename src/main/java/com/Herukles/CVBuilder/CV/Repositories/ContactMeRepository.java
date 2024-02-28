package com.Herukles.CVBuilder.CV.Repositories;

import com.Herukles.CVBuilder.CV.Models.Entities.ContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMeRepository extends JpaRepository<ContactInfoEntity, Long> {
}
