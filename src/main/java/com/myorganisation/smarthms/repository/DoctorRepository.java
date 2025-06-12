package com.myorganisation.smarthms.repository;

import com.myorganisation.smarthms.model.Doctor;
import com.myorganisation.smarthms.model.enums.Gender;
import com.myorganisation.smarthms.model.enums.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    //Custom finder method
    List<Doctor> findByNameContaining(String name);
    List<Doctor> findByName(String name);
    List<Doctor> findByNameContainingAndGender(String name, Gender gender);

    //Custom JPQL Query
    @Query("SELECT d FROM Doctor d WHERE d.gender = :gender AND d.specialization = :specialization")
    List<Doctor> searchDoctorsByGenderAndSpecialization(@Param("gender") Gender gender, @Param("specialization") Specialization specialization);

    //Custom SQL Query
    @Query(value = "SELECT * FROM doctor d WHERE d.name LIKE %:name%", nativeQuery = true)
    List<Doctor> searchDoctorsByNameLike(@Param("name") String name);
}
