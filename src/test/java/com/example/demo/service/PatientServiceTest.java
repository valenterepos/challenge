package com.example.demo.service;

import com.example.demo.dto.PatientOutDTO;
import com.example.demo.dto.PatientsConsultsResponseDTO;
import com.example.demo.model.*;
import com.example.demo.repository.ConsultRepository;
import com.example.demo.repository.PathologyRepository;
import com.example.demo.repository.PatientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private ConsultRepository consultRepository;

    @Mock
    private PathologyRepository pathologyRepository;

    @InjectMocks
    private PatientService patientService;

    @Test
    @DisplayName("Retrieve all patients")
    void getAllPatients() {

        //arrange
        List<Patient> patients = Arrays.asList(
                new Patient("John", 30),
                new Patient("Mark", 28)
        );

        //act
        when(patientRepository.findAll()).thenReturn(patients);

        List<PatientOutDTO> result = patientService.getAllPatients();

        //assert
        assertEquals(2, result.size());
        verify(patientRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Get patient consults and symptoms")
    void getPatientConsults() {

        //arrange
        Patient testPatient = getTestPatient();

        Doctor doctor = new Doctor("Smith", Specialty.PEDIATRICS, new ArrayList<>());
        Consult consult = new Consult(doctor, testPatient);
        testPatient.setConsults(List.of(consult));

        Symptom symptom1 = new Symptom(1L, "Fever");
        Symptom symptom2 = new Symptom(2L, "Cough");
        Pathology pathology = new Pathology(1L, "Flu", List.of(symptom1, symptom2));
        testPatient.setPathologies(List.of(pathology));

        //act
        when(patientRepository.findById(1L)).thenReturn(Optional.of(testPatient));

        PatientsConsultsResponseDTO response = patientService.getPatientConsults(1L);

        //assert
        assertNotNull(response);
        assertEquals(1, response.getConsults().size());
        assertEquals("Smith", response.getConsults().get(0).getDoctor());
        assertEquals("PEDIATRICS", response.getConsults().get(0).getSpecialty());
        assertEquals(2, response.getSymptoms().size());
        assertEquals("Fever", response.getSymptoms().get(0).getDescription());

        verify(patientRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Throw exception when patient is not found")
    void getPatientConsults_PatientNotFound() {

        //arrange-act
        when(patientRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            patientService.getPatientConsults(1L);
        });

        //assert
        assertEquals("Patient not found", exception.getMessage());
    }

    private Patient getTestPatient() {
        Patient testPatient = new Patient("John", 30);
        testPatient.setId(1L);
        return testPatient;
    }
}