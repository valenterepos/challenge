package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "pathology_id")
    )
    private List<Pathology> pathologies;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
        this.consults = new ArrayList<>();
        this.pathologies = new ArrayList<>();
    }

    public List<Consult> getConsults() {
        return new ArrayList<>(consults);
    }

    public List<Pathology> getPathologies() {
        return new ArrayList<>(pathologies);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setConsults(List<Consult> consults) {
        this.consults = consults;
    }

    public void setPathologies(List<Pathology> pathologies) {
        this.pathologies = pathologies;
    }


}
