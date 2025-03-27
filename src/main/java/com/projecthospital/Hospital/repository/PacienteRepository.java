package com.projecthospital.Hospital.repository;

import com.projecthospital.Hospital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}