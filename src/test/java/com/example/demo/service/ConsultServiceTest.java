package com.example.demo.service;

import com.example.demo.dto.ConsultInDTO;
import com.example.demo.dto.ConsultOutDTO;
import com.example.demo.dto.TopSpecialityResponseDTO;
import com.example.demo.model.Consult;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Specialty;
import com.example.demo.repository.ConsultRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ConsultServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private ConsultRepository consultRepository;

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private ConsultService consultService;

    @Test
    @DisplayName("Create a valid consult")
    void createConsult() {
        //arrange
        Doctor testDoctor = new Doctor("Mark", Specialty.RADIOLOGY, new ArrayList<>());
        testDoctor.setId(1L);

        Patient testPatient = new Patient("John", 30);
        testPatient.setId(2L);

        Consult testConsult = new Consult(testDoctor, testPatient);
        testConsult.setId(10L);

        //act
        when(doctorRepository.findById(1L)).thenReturn(Optional.of(testDoctor));
        when(patientRepository.findById(2L)).thenReturn(Optional.of(testPatient));
        when(consultRepository.save(any(Consult.class))).thenReturn(testConsult);

        ConsultInDTO consultInDTO = new ConsultInDTO(1L, 2L);

        ConsultOutDTO createdConsult = consultService.createConsult(
                consultInDTO.getDoctorId(), consultInDTO.getPatientId());

        //Assert
        assertNotNull(createdConsult);
        assertEquals(10L, createdConsult.getId());
        assertEquals(1L, createdConsult.getDoctorId());
        assertEquals(2L, createdConsult.getPatientId());

        verify(consultRepository, times(1)).save(any(Consult.class));
    }

    @Test
    @DisplayName("Get the top Hospital Specialities")
    void getTopSpecialities() {
        List<Consult> consultsList = setupHospitalConsults();
        when(consultRepository.findAll()).thenReturn(consultsList);

        List<TopSpecialityResponseDTO> specialityResult = consultService.getTopSpecialities();

        assertEquals(2, specialityResult.size());
        assertEquals("OPHTHALMOLOGY", specialityResult.get(0).getSpecialityName());
        assertEquals(3, specialityResult.get(0).getNumberOfPatients());

        assertEquals("DERMATOLOGY", specialityResult.get(1).getSpecialityName());
        assertEquals(3, specialityResult.get(1).getNumberOfPatients());

    }

    private List<Consult> setupHospitalConsults() {

        Doctor dermatologyDoctor = new Doctor("Dr. A", Specialty.DERMATOLOGY, Collections.emptyList());
        Doctor ophthalmologyDoctor = new Doctor("Dr. B", Specialty.OPHTHALMOLOGY, Collections.emptyList());
        Doctor radiologyDoctor = new Doctor("Dr. C", Specialty.RADIOLOGY, Collections.emptyList());

        Patient patient1 = new Patient("Alice", 25);
        patient1.setId(1L);
        Patient patient2 = new Patient("Bob", 30);
        patient2.setId(2L);
        Patient patient3 = new Patient("Charlie", 40);
        patient3.setId(3L);
        Patient patient4 = new Patient("David", 50);
        patient4.setId(4L);

        Consult consult1 = new Consult(dermatologyDoctor, patient1);
        Consult consult2 = new Consult(dermatologyDoctor, patient2);
        Consult consult3 = new Consult(dermatologyDoctor, patient3);

        Consult consult4 = new Consult(ophthalmologyDoctor, patient1);
        Consult consult5 = new Consult(ophthalmologyDoctor, patient2);
        Consult consult6 = new Consult(ophthalmologyDoctor, patient3);

        Consult consult7 = new Consult(radiologyDoctor, patient4);

        Consult consult8 = new Consult(dermatologyDoctor, patient1);
        return Arrays.asList(consult1, consult2, consult3, consult4, consult5, consult6, consult7, consult8);
    }
}