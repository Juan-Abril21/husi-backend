package com.projecthospital.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecthospital.Hospital.orm.Espacio;

public interface EspacioRepository extends JpaRepository<Espacio, Long> {
}

