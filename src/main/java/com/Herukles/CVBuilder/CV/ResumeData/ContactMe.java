package com.Herukles.CVBuilder.CV.ResumeData;

import lombok.Data;

@Data
public class ContactMe {
    private String phoneNumber;
    private String email;
    private String website;

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
