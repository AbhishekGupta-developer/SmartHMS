package com.myorganisation.smarthms.service;

import com.myorganisation.smarthms.dto.PatientRequestDTO;
import com.myorganisation.smarthms.dto.PatientResponseDTO;

import java.util.List;

public interface PatientService {
    PatientResponseDTO registerPatient(PatientRequestDTO patientRequestDTO);
    PatientResponseDTO getPatient(Long id);
    List<PatientResponseDTO> getAllPatients();
    PatientResponseDTO updatePatient(Long id, PatientRequestDTO patientRequestDTO);
    String removePatient(Long id);
}
