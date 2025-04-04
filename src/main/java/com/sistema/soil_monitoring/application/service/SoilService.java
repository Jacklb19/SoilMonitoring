package com.sistema.soil_monitoring.application.service;

import com.sistema.soil_monitoring.domain.model.Soil;
import java.util.List;
import java.util.Optional;

public interface SoilService {

    Soil save(Soil soil);
    List<Soil> listAll();
    Optional<Soil> findById(Long id);
    Soil update(Long id, Soil uptadeSoil);
    Soil partialUpdate(Long id, Soil updatedFields);
    void delete(Long id);
}
