package com.myorganisation.smarthms.dto;

import com.myorganisation.smarthms.model.enums.Gender;
import com.myorganisation.smarthms.model.enums.Shift;
import com.myorganisation.smarthms.model.enums.Specialization;
import lombok.Data;

@Data
public class DoctorRequestDTO {

    private String name;
    private Gender gender;
    private Specialization specialization;
    private Shift shift;
    private String email;
    private String phone;
    private String password;
}
