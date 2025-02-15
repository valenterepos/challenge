package com.example.demo.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pathology")
@NoArgsConstructor
public class Pathology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "pathology_symptoms",
            joinColumns = @JoinColumn(name = "pathology_id")
    )
    private List<Symptom> symptoms;

    public Pathology(Long id, String name, List<Symptom> symptoms) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
    }

    public List<Symptom> getSymptoms(){
        return new ArrayList<>(symptoms);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
