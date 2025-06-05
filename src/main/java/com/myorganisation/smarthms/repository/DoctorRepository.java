package com.myorganisation.smarthms.repository;

import com.myorganisation.smarthms.model.Doctor;
import com.myorganisation.smarthms.model.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    //Custom finder method
    List<Doctor> findByNameContaining(String name);
    List<Doctor> findByName(String name);
    List<Doctor> findByNameContainingAndGender(String name, Gender gender);
}
