package com.projecthospital.Hospital.controller;

import com.projecthospital.Hospital.orm.Cita;
import com.projecthospital.Hospital.service.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<Cita> obtenerTodas() {
        return citaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtenerPorId(@PathVariable Long id) {
        return citaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cita crear(@RequestBody Cita cita) {
        return citaService.guardar(cita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizar(@PathVariable Long id, @RequestBody Cita cita) {
        if (!citaService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cita.setId(id);
        return ResponseEntity.ok(citaService.guardar(cita));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!citaService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        citaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

