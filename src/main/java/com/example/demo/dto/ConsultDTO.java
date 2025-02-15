package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ConsultDTO {

    private Long consultId;
    private String doctor;
    private String specialty;

    public ConsultDTO(Long consultId, String doctor, String specialty) {
        this.consultId = consultId;
        this.doctor = doctor;
        this.specialty = specialty;
    }
}
