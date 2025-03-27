package com.projecthospital.Hospital.controller;

import com.projecthospital.Hospital.orm.Paciente;
import com.projecthospital.Hospital.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> obtenerTodos() {
        return pacienteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPorId(@PathVariable Long id) {
        return pacienteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paciente crear(@RequestBody Paciente paciente) {
        return pacienteService.guardar(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
        if (!pacienteService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        paciente.setId(id);
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!pacienteService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pacienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

