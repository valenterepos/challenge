package com.example.demo.service;

import com.example.demo.dto.ConsultOutDTO;
import com.example.demo.model.Consult;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.repository.ConsultRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultService {
    private final ConsultRepository consultRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public ConsultService(ConsultRepository consultRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.consultRepository = consultRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public ConsultOutDTO createConsult(Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        Consult consult = new Consult(doctor, patient);
        Consult savedConsult = consultRepository.save(consult);

        ConsultOutDTO response = new ConsultOutDTO();
        response.setId(savedConsult.getId());
        response.setDoctorId(savedConsult.getDoctor().getId());
        response.setPatientId(savedConsult.getPatient().getId());

        return response;
    }
}
