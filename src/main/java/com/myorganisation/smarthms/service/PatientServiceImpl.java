package com.myorganisation.smarthms.service;

import com.myorganisation.smarthms.dto.PatientRequestDTO;
import com.myorganisation.smarthms.dto.PatientResponseDTO;
import com.myorganisation.smarthms.model.Patient;
import com.myorganisation.smarthms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public PatientResponseDTO registerPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();

        patient.setName(patientRequestDTO.getName());
        patient.setDisease(patientRequestDTO.getDisease());

        patientRepository.save(patient);

        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        patientResponseDTO.setId(patient.getId());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setDisease(patient.getDisease());

        return patientResponseDTO;
    }

    @Override
    public PatientResponseDTO getPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);

        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        patientResponseDTO.setId(patient.getId());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setDisease(patient.getDisease());

        return patientResponseDTO;
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();

        List<PatientResponseDTO> patientResponseDTOList = new LinkedList<>();

        for(Patient patient : patientList) {
            PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

            patientResponseDTO.setId(patient.getId());
            patientResponseDTO.setName(patient.getName());
            patientResponseDTO.setDisease(patient.getDisease());

            patientResponseDTOList.add(patientResponseDTO);
        }

        return patientResponseDTOList;
    }

    @Override
    public PatientResponseDTO updatePatient(Long id, PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.findById(id).orElse(null);

        patient.setName(patientRequestDTO.getName());
        patient.setDisease(patientRequestDTO.getDisease());

        patientRepository.save(patient);

        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        patientResponseDTO.setId(patient.getId());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setDisease(patient.getDisease());

        return patientResponseDTO;
    }

    @Override
    public String removePatient(Long id) {
        String name = patientRepository.findById(id).orElse(null).getName();
        patientRepository.deleteById(id);

        return "Patient: " + name + "(ID: " + id + ") has been removed successfully.";
    }
}
