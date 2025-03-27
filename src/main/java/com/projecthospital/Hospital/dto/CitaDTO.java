package com.projecthospital.Hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaDTO {
    private Long id;
    private Long espacioId;
    private LocalDateTime hora;
    private Long pacienteId;
    private String doctor;
}