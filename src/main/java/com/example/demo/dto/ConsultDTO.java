package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class ConsultDTO {

    private Long consultId;
    private String doctor;
    private String specialty;

    public ConsultDTO(Long consultId, String doctor, String specialty) {
        this.consultId = consultId;
        this.doctor = doctor;
        this.specialty = specialty;
    }

    public Long getConsultId() {
        return consultId;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
