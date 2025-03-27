package com.projecthospital.Hospital.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "espacios")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Espacio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean disponibilidad;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}

