package com.projecthospital.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecthospital.Hospital.orm.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}