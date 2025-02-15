package com.example.demo.controller;
import com.example.demo.dto.ConsultInDTO;
import com.example.demo.dto.ConsultOutDTO;
import com.example.demo.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consults")
public class ConsultController {
    private final ConsultService consultService;

    @Autowired
    public ConsultController(ConsultService consultService){
        this.consultService = consultService;
    }


    @PostMapping
    public ResponseEntity<Object> createConsult(@RequestBody ConsultInDTO consultInDTO) {
        try {
            ConsultOutDTO result = consultService.createConsult(consultInDTO.getDoctorId(), consultInDTO.getPatientId());
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
