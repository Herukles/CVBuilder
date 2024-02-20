package com.Herukles.CVBuilder.CV.Repository;

import com.Herukles.CVBuilder.CV.Models.ContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMeRepository extends JpaRepository<ContactInfoEntity, Long> {
}
