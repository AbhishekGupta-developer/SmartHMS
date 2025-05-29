package com.myorganisation.smarthms.service;

import com.myorganisation.smarthms.dto.DoctorRequestDTO;
import com.myorganisation.smarthms.dto.DoctorResponseDTO;

import java.util.List;

public interface DoctorService {
    DoctorResponseDTO registerDoctor(DoctorRequestDTO doctorRequestDTO);
    DoctorResponseDTO getDoctor(Long id);
    List<DoctorResponseDTO> getAllDoctors();
    DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO doctorRequestDTO);
    String removeDoctor(Long id);
}
