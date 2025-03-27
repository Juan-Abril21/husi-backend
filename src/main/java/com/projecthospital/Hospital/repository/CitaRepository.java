package com.projecthospital.Hospital.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.projecthospital.Hospital.orm.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}

