package com.myorganisation.smarthms.controller;

import com.myorganisation.smarthms.dto.PatientRequestDTO;
import com.myorganisation.smarthms.dto.PatientResponseDTO;
import com.myorganisation.smarthms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponseDTO> registerPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        return new ResponseEntity<>(patientService.registerPatient(patientRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getPatient(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(patientService.getPatient(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable(name = "id") Long id, @RequestBody PatientRequestDTO patientRequestDTO) {
        return new ResponseEntity<>(patientService.updatePatient(id, patientRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> removePatient(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(patientService.removePatient(id), HttpStatus.OK);
    }

}
