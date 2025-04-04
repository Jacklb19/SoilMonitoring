package com.sistema.soil_monitoring.application.decorator;

import com.sistema.soil_monitoring.application.service.SoilService;
import com.sistema.soil_monitoring.domain.model.Soil;

import java.util.List;
import java.util.Optional;

public class MetricsMonitoringDecorator extends SoilServiceDecorator{

    public MetricsMonitoringDecorator(SoilService soilService) {
        super(soilService);
    }

    @Override
    public Soil save(Soil soil) {
        long startTime = System.currentTimeMillis();
        Soil result = super.save(soil);
        long endTime = System.currentTimeMillis();
        System.out.println("[METRICS] save() tardó: " + (endTime - startTime) + " ms");
        return result;
    }

    @Override
    public List<Soil> listAll() {
        long startTime = System.currentTimeMillis();
        List<Soil> soils = super.listAll();
        long endTime = System.currentTimeMillis();
        System.out.println("[METRICS] listAll() tardó: " + (endTime - startTime) + " ms");
        return soils;
    }

    @Override
    public Optional<Soil> findById(Long id) {
        long startTime = System.currentTimeMillis();
        Optional<Soil> result = super.findById(id);
        long endTime = System.currentTimeMillis();
        System.out.println("[METRICS] findById(" + id + ") tardó: " + (endTime - startTime) + " ms");
        return result;
    }

    @Override
    public Soil update(Long id, Soil updatedSoil) {
        long startTime = System.currentTimeMillis();
        Soil result = super.update(id, updatedSoil);
        long endTime = System.currentTimeMillis();
        System.out.println("[METRICS] update(" + id + ") tardó: " + (endTime - startTime) + " ms");
        return result;
    }

    @Override
    public Soil partialUpdate(Long id, Soil updatedSoil) {
        long startTime = System.currentTimeMillis();
        Soil result = super.partialUpdate(id, updatedSoil);
        long endTime = System.currentTimeMillis();
        System.out.println("[METRICS] partialUpdate(" + id + ") tardó: " + (endTime - startTime) + " ms");
        return result;
    }

    @Override
    public void delete(Long id) {
        long startTime = System.currentTimeMillis();
        super.delete(id);
        long endTime = System.currentTimeMillis();
        System.out.println("[METRICS] delete(" + id + ") tardó: " + (endTime - startTime) + " ms");
    }
}
