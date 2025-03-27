package com.projecthospital.Hospital.orm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "cita")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "espacio")
    private String espacio;
    
    @Column(name = "hora")
    private LocalDateTime hora;

    @Column(name = "paciente")
    private String paciente;
    
    @Column(name = "doctor")
    private String doctor;
}