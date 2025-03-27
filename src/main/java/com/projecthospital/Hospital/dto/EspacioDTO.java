package com.projecthospital.Hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspacioDTO {
    private Long id;
    private Boolean disponibilidad;
    private Long pacienteId;
}
