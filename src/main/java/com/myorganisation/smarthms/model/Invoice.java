package com.myorganisation.smarthms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myorganisation.smarthms.model.enums.InvoiceStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount = 1000.0D;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status = InvoiceStatus.UNPAID;

    @OneToOne
    @JsonIgnore
    private Patient patient;
}
