package com.example.demo.service;

import com.example.demo.dto.ConsultDTO;
import com.example.demo.dto.PatientOutDTO;
import com.example.demo.dto.PatientsConsultsResponseDTO;
import com.example.demo.dto.SymptomDTO;
import com.example.demo.model.Consult;
import com.example.demo.model.Pathology;
import com.example.demo.model.Patient;
import com.example.demo.repository.ConsultRepository;
import com.example.demo.repository.PathologyRepository;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final ConsultRepository consultRepository;
    private final PathologyRepository pathologyRepository;
    @Autowired
    public PatientService(PatientRepository patientRepository, ConsultRepository consultRepository, PathologyRepository pathologyRepository) {
        this.patientRepository = patientRepository;
        this.consultRepository = consultRepository;
        this.pathologyRepository = pathologyRepository;
    }

    public List<PatientOutDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PatientOutDTO convertToDTO(Patient patient) {
        PatientOutDTO dto = new PatientOutDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setAge(patient.getAge());

        dto.setConsults(patient.getConsults().stream()
                .map(Consult::getId)
                .collect(Collectors.toList()));

        dto.setPathologies(patient.getPathologies().stream()
                .map(Pathology::getId)
                .collect(Collectors.toList()));

        return dto;
    }

    public PatientsConsultsResponseDTO getPatientConsults(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        List<ConsultDTO> consults = patient.getConsults().stream()
                .map(c -> new ConsultDTO(
                        c.getId(),
                        c.getDoctor().getName(),
                        c.getDoctor().getSpecialty().name()
                ))
                .collect(Collectors.toList());


        List<SymptomDTO> symptomsLists = patient.getPathologies().stream()
                .flatMap(pathology -> pathology.getSymptoms().stream()
                        .map(s -> new SymptomDTO(s.getId(), s.getDescription())))
                .collect(Collectors.toList());


        return new PatientsConsultsResponseDTO(consults, new ArrayList<>(symptomsLists));
    }



}
