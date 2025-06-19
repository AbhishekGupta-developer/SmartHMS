package com.myorganisation.smarthms.dto;

import com.myorganisation.smarthms.model.Invoice;
import lombok.Data;

@Data
public class PatientResponseDTO {
    private Long id;
    private String name;
    private String disease;
    private Invoice invoice;
}
