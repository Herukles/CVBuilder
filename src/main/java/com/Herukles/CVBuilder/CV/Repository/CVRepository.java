package com.Herukles.CVBuilder.CV.Repository;

import com.Herukles.CVBuilder.CV.Models.PersonalInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepository extends JpaRepository<PersonalInformationEntity, Long> {

}
