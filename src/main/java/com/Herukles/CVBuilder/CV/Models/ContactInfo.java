package com.Herukles.CVBuilder.CV.Models;


import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Component
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfo {
    private String phoneNumber;
    private String email;
    private String website;
}
