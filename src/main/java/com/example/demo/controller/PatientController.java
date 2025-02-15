package com.example.demo.controller;

import com.example.demo.dto.PatientOutDTO;
import com.example.demo.dto.PatientsConsultsResponseDTO;
import com.example.demo.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patients", description = "API to manage patients")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @Operation(summary = "Get all patients")
    @GetMapping
    public ResponseEntity<List<PatientOutDTO>> getAllPatients() {
        List<PatientOutDTO> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }
    @Operation(summary = "Get patient consults and symptoms")
    @GetMapping("/{patientId}/consults")
    public ResponseEntity<PatientsConsultsResponseDTO> getPatientConsults(@PathVariable Long patientId) {

        return ResponseEntity.ok(patientService.getPatientConsults(patientId));
    }
}
