package com.example.demo.dto;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class SymptomDTO {

    private Long symptomId;

    private String description;
    public SymptomDTO(Long symptomId, String description) {
        this.symptomId = symptomId;
        this.description = description;
    }

}
