package com.myorganisation.smarthms.service;

import com.myorganisation.smarthms.dto.DoctorRequestDTO;
import com.myorganisation.smarthms.dto.DoctorResponseDTO;
import com.myorganisation.smarthms.model.Doctor;
import com.myorganisation.smarthms.model.enums.Gender;
import com.myorganisation.smarthms.model.enums.Specialization;
import com.myorganisation.smarthms.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public DoctorResponseDTO registerDoctor(DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = copyDoctorRequestDTOToDoctor(doctorRequestDTO, new Doctor());
        doctor = doctorRepository.save(doctor);
        return convertDoctorToDoctorResponseDTO(doctor);
    }

    @Override
    public DoctorResponseDTO getDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        return convertDoctorToDoctorResponseDTO(doctor);
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        List<DoctorResponseDTO> doctorResponseDTOList = new ArrayList<>();
        for(Doctor doctor : doctorList) {
            doctorResponseDTOList.add(convertDoctorToDoctorResponseDTO(doctor));
        }
        return doctorResponseDTOList;
    }

    @Override
    public DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        copyDoctorRequestDTOToDoctor(doctorRequestDTO, doctor);
        doctorRepository.save(doctor);
        return convertDoctorToDoctorResponseDTO(doctor);
    }

    @Override
    public String removeDoctor(Long id) {
        String name = doctorRepository.findById(id).orElse(null).getName();
        doctorRepository.deleteById(id);
        return "Doctor: " + name + "(ID: " + id + ") has been removed successfully!";
    }

    @Override
    public List<DoctorResponseDTO> getDoctorByName(String name) {
        List<Doctor> doctorList = doctorRepository.findByNameContaining(name);

        List<DoctorResponseDTO> doctorResponseDTOList = new ArrayList<>();

        for(Doctor doctor : doctorList) {
            DoctorResponseDTO doctorResponseDTO = convertDoctorToDoctorResponseDTO(doctor);
            doctorResponseDTOList.add(doctorResponseDTO);
        }

        return doctorResponseDTOList;
    }

    @Override
    public List<DoctorResponseDTO> getDoctorByNameAndGender(String name, Gender gender) {
        List<Doctor> doctorList = doctorRepository.findByNameContainingAndGender(name, gender);

        List<DoctorResponseDTO> doctorResponseDTOList = new ArrayList<>();

        for(Doctor doctor : doctorList) {
            DoctorResponseDTO doctorResponseDTO = convertDoctorToDoctorResponseDTO(doctor);
            doctorResponseDTOList.add(doctorResponseDTO);
        }

        return doctorResponseDTOList;
    }

    @Override
    public List<DoctorResponseDTO> getDoctorsByGenderAndSpecialization(Gender gender, Specialization specialization) {
        List<Doctor> doctorList = doctorRepository.searchDoctorsByGenderAndSpecialization(gender, specialization);
        List<DoctorResponseDTO> doctorResponseDTOList = new ArrayList<>();

        for(Doctor doctor : doctorList) {
            DoctorResponseDTO doctorResponseDTO = convertDoctorToDoctorResponseDTO(doctor);
            doctorResponseDTOList.add(doctorResponseDTO);
        }

        return doctorResponseDTOList;
    }

    @Override
    public List<DoctorResponseDTO> getDoctorsByNameLike(String name) {
        List<Doctor> doctorList = doctorRepository.searchDoctorsByNameLike(name);
        List<DoctorResponseDTO> doctorResponseDTOList = new ArrayList<>();

        for(Doctor doctor : doctorList) {
            DoctorResponseDTO doctorResponseDTO = convertDoctorToDoctorResponseDTO(doctor);
            doctorResponseDTOList.add(doctorResponseDTO);
        }

        return doctorResponseDTOList;
    }

    //Helper methods

    //Copy DoctorRequestDTO to Doctor
    private Doctor copyDoctorRequestDTOToDoctor(DoctorRequestDTO doctorRequestDTO, Doctor doctor) {
        doctor.setName(doctorRequestDTO.getName());
        doctor.setGender(doctorRequestDTO.getGender());
        doctor.setSpecialization(doctorRequestDTO.getSpecialization());
        doctor.setShift(doctorRequestDTO.getShift());
        doctor.setEmail(doctorRequestDTO.getEmail());
        doctor.setPhone(doctorRequestDTO.getPhone());
        doctor.setPassword(doctorRequestDTO.getPassword());

        return doctor;
    }

    //Convert Doctor to DoctorResponseDTO
    private DoctorResponseDTO convertDoctorToDoctorResponseDTO(Doctor doctor) {
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setId(doctor.getId());
        doctorResponseDTO.setName(doctor.getName());
        doctorResponseDTO.setGender(doctor.getGender());
        doctorResponseDTO.setSpecialization(doctor.getSpecialization());
        doctorResponseDTO.setShift(doctor.getShift());
        doctorResponseDTO.setEmail(doctor.getEmail());
        doctorResponseDTO.setPhone(doctor.getPhone());

        return doctorResponseDTO;
    }

}
