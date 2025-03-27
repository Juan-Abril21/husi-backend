package com.projecthospital.Hospital.controller;

import com.projecthospital.Hospital.model.Espacio;
import com.projecthospital.Hospital.service.EspacioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
public class EspacioController {

    private final EspacioService espacioService;

    public EspacioController(EspacioService espacioService) {
        this.espacioService = espacioService;
    }

    @GetMapping
    public List<Espacio> obtenerTodos() {
        return espacioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Espacio> obtenerPorId(@PathVariable Long id) {
        return espacioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Espacio crear(@RequestBody Espacio espacio) {
        return espacioService.guardar(espacio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Espacio> actualizar(@PathVariable Long id, @RequestBody Espacio espacio) {
        if (!espacioService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        espacio.setId(id);
        return ResponseEntity.ok(espacioService.guardar(espacio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!espacioService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        espacioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
