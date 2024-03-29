package com.Herukles.CVBuilder.CV.Converters;

import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Models.Entities.ContactInfoEntity;

public class ContactInfoConverter {
    public static ContactInfo contactInfoEntityToContactInfo(ContactInfoEntity contactInfoEntity) {
        return ContactInfo.builder()
                .email(contactInfoEntity.getEmail())
                .website(contactInfoEntity.getWebsite())
                .phoneNumber(contactInfoEntity.getPhoneNumber())
                .build();
    }
    public static ContactInfoEntity contactInfoToContactInfoEntity(ContactInfo contactInfo) {
        return ContactInfoEntity.builder()
                .email(contactInfo.getEmail())
                .website(contactInfo.getWebsite())
                .phoneNumber(contactInfo.getPhoneNumber())
                .build();
    }
}
