package com.myorganisation.smarthms.service;

import com.myorganisation.smarthms.dto.DoctorRequestDTO;
import com.myorganisation.smarthms.dto.DoctorResponseDTO;
import com.myorganisation.smarthms.model.enums.Gender;
import com.myorganisation.smarthms.model.enums.Specialization;

import java.util.List;

public interface DoctorService {
    DoctorResponseDTO registerDoctor(DoctorRequestDTO doctorRequestDTO);
    DoctorResponseDTO getDoctor(Long id);
    List<DoctorResponseDTO> getAllDoctors();
    DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO doctorRequestDTO);
    String removeDoctor(Long id);

    List<DoctorResponseDTO> getDoctorByName(String name);
    List<DoctorResponseDTO> getDoctorByNameAndGender(String name, Gender gender);

    List<DoctorResponseDTO> getDoctorsByGenderAndSpecialization(Gender gender, Specialization specialization);
    List<DoctorResponseDTO> getDoctorsByNameLike(String name);
}
