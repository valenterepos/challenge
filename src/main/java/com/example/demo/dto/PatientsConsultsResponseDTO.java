package com.example.demo.dto;

import java.util.List;

public class PatientsConsultsResponseDTO {
    private List<ConsultDTO> consults;
    private List<SymptomDTO> symptoms;

    public PatientsConsultsResponseDTO(List<ConsultDTO> consults, List<SymptomDTO> symptoms) {
        this.consults = consults;
        this.symptoms = symptoms;
    }

    public List<ConsultDTO> getConsults() {
        return consults;
    }

    public List<SymptomDTO> getSymptoms() {
        return symptoms;
    }

}
