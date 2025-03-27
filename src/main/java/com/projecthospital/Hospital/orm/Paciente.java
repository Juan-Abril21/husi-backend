package com.projecthospital.Hospital.orm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "cedula", nullable = false, unique = true)
    private String cedula;
    
    @Column(name = "estado")
    private String estado;
}
