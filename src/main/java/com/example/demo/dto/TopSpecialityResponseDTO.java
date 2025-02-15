package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopSpecialityResponseDTO {

    private String specialityName;
    private int numberOfPatients;

    public TopSpecialityResponseDTO(String specialityName, int numberOfPatients) {
        this.specialityName = specialityName;
        this.numberOfPatients = numberOfPatients;
    }
    public String getSpecialityName() {
        return specialityName;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }
}