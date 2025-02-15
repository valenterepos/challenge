package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientOutDTO {
    private Long id;
    private String name;
    private Integer age;
    private List<Long> consults;
    private List<Long> pathologies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAge(Integer age) {
        this.age = age;
    }

    public void setConsults(List<Long> consults) {
        this.consults = consults;
    }

    public void setPathologies(List<Long> pathologies) {
        this.pathologies = pathologies;
    }
}
