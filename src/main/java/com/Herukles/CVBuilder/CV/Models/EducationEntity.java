package com.Herukles.CVBuilder.CV.Models;

import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Data
@Component
@Scope("prototype")
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EducationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne()
    CVEntity cvEntity;

    String nameOfInstitution;
    LocalDate educationDateStart;
    LocalDate educationDateEnd;
}
