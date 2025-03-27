package com.projecthospital.Hospital.service;

import com.projecthospital.Hospital.model.Espacio;
import com.projecthospital.Hospital.repository.EspacioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspacioService {

    private final EspacioRepository espacioRepository;

    public EspacioService(EspacioRepository espacioRepository) {
        this.espacioRepository = espacioRepository;
    }

    public List<Espacio> obtenerTodos() {
        return espacioRepository.findAll();
    }

    public Optional<Espacio> obtenerPorId(Long id) {
        return espacioRepository.findById(id);
    }

    public Espacio guardar(Espacio espacio) {
        return espacioRepository.save(espacio);
    }

    public void eliminar(Long id) {
        espacioRepository.deleteById(id);
    }
}
