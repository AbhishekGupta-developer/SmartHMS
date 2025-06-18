package com.myorganisation.smarthms.model;

import com.myorganisation.smarthms.model.enums.Gender;
import com.myorganisation.smarthms.model.enums.Shift;
import com.myorganisation.smarthms.model.enums.Specialization;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Enumerated(EnumType.STRING)
    private Shift shift;
    private String email;
    private String phone;
    private String password;

}
