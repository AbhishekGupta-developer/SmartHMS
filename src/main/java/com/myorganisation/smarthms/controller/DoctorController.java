package com.myorganisation.smarthms.controller;

import com.myorganisation.smarthms.dto.DoctorRequestDTO;
import com.myorganisation.smarthms.dto.DoctorResponseDTO;
import com.myorganisation.smarthms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> registerDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO) {
        return new ResponseEntity<>(doctorService.registerDoctor(doctorRequestDTO), HttpStatusCode.valueOf(201));
    }
}
