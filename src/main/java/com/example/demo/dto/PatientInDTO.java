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
public class PatientInDTO {
    private String name;
    private Integer age;

    private List<Long> consults;
    private List<Long> pathologies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Long> getConsults() {
        return consults;
    }

    public void setConsults(List<Long> consults) {
        this.consults = consults;
    }

    public List<Long> getPathologies() {
        return pathologies;
    }

    public void setPathologies(List<Long> pathologies) {
        this.pathologies = pathologies;
    }
}
