package com.Herukles.CVBuilder.CV.Models.Entities;

import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.LocalDate;


@Component
@Data
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cv_id")
    private CVEntity cvEntity;

    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String companyName;
    private String description;
}
