package com.projecthospital.Hospital.orm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "espacio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Espacio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "disponibilidad")
    private Boolean disponibilidad;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "paciente")
    private String paciente;
}
