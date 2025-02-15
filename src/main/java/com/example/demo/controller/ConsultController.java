package com.example.demo.controller;
import com.example.demo.dto.ConsultInDTO;
import com.example.demo.dto.ConsultOutDTO;
import com.example.demo.dto.TopSpecialityResponseDTO;
import com.example.demo.service.ConsultService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/consults")
@Tag(name = "Consults", description = "API to manage consults")
public class ConsultController {
    private final ConsultService consultService;

    @Autowired
    public ConsultController(ConsultService consultService){
        this.consultService = consultService;
    }


    @Operation(summary = "Create a new consult")
    @PostMapping
    public ResponseEntity<Object> createConsult(@RequestBody ConsultInDTO consultDTO) {
        try {
            ConsultOutDTO result = consultService.createConsult(consultDTO.getDoctorId(), consultDTO.getPatientId());
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Retrieve the top specialities from the hospital")
    @GetMapping("/topSpecialities")
    public ResponseEntity<Object> getTopSpecialities() {
        try {
            List<TopSpecialityResponseDTO> result = consultService.getTopSpecialities();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
