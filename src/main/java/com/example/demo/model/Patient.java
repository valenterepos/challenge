package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consult> consults;

    @ManyToMany
    @JoinTable(
            name = "patient_pathologies",
            joinColumns = @JoinColumn(name = "pathology_id")
    )
    private List<Pathology> pathologies;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
        this.consults = new ArrayList<>();
        this.pathologies = new ArrayList<>();
    }


}
