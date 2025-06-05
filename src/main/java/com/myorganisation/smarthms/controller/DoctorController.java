package com.myorganisation.smarthms.controller;

import com.myorganisation.smarthms.dto.DoctorRequestDTO;
import com.myorganisation.smarthms.dto.DoctorResponseDTO;
import com.myorganisation.smarthms.model.enums.Gender;
import com.myorganisation.smarthms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> registerDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO) {
        return new ResponseEntity<>(doctorService.registerDoctor(doctorRequestDTO), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctor(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(doctorService.getDoctor(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> updateDoctor(@PathVariable(name = "id") Long id, @RequestBody DoctorRequestDTO doctorRequestDTO) {
        return new ResponseEntity<>(doctorService.updateDoctor(id, doctorRequestDTO), HttpStatusCode.valueOf(201));
    }

    @DeleteMapping
    public ResponseEntity<String> removeDoctor(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(doctorService.removeDoctor(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/search")
    public ResponseEntity<List<DoctorResponseDTO>> getDoctorByName(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(doctorService.getDoctorByName(name), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find")
    public ResponseEntity<List<DoctorResponseDTO>> getDoctorByNameAndGender(@RequestParam(name = "name") String name, @RequestParam(name = "gender") Gender gender) {
        return new ResponseEntity<>(doctorService.getDoctorByNameAndGender(name, gender), HttpStatusCode.valueOf(200));
    }
}
