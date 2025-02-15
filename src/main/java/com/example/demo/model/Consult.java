package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consult")
@NoArgsConstructor
@Getter
@Setter
public class Consult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    public Consult(Doctor doctor, Patient patient) {
        if (doctor == null || patient == null) {
            throw new IllegalArgumentException("Doctor and Patient must be provided for a Consult.");
        }
        this.doctor = doctor;
        this.patient = patient;
    }


}
