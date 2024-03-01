package com.Herukles.CVBuilder.CV.Models;

import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
@Scope("prototype")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    LocalDate dateStart;
    LocalDate dateEnd;
    String companyName;
    String description;

    CV cv;
}
