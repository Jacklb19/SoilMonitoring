package com.sistema.soil_monitoring.infraestructure.controller;

import com.sistema.soil_monitoring.application.service.SoilService;
import com.sistema.soil_monitoring.domain.model.Soil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suelos")
public class SoilController {
    private final SoilService soilService;

    public SoilController(SoilService soilService) {
        this.soilService = soilService;
    }

    @PostMapping
    public Soil save(@RequestBody Soil soil) {
        Soil savedSoil = soilService.save(soil);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSoil).getBody();
    }

    @GetMapping
    public ResponseEntity<List<Soil>> findAll() {
        return ResponseEntity.ok(soilService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Optional<Soil> soil = soilService.findById(id);
        return soil.map(s -> ResponseEntity.ok((Object) s))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Suelo con id " + id + " no fue encontrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Soil updateSoil) {
        try {
            return ResponseEntity.ok(soilService.update(id, updateSoil));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Suelo con id " + id + " no fue encontrado");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable Long id, @RequestBody Soil updatedFields) {
        try {
            return ResponseEntity.ok(soilService.partialUpdate(id, updatedFields));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Suelo con id " + id + " no fue encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            soilService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Suelo con id " + id + " no fue encontrado");
        }
    }
}

