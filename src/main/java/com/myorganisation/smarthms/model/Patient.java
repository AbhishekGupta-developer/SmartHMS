package com.myorganisation.smarthms.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String disease;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice")
    private Invoice invoice;
}
