package com.Herukles.CVBuilder.CV.Repository;

import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfoEntity, Long> {

}
