package com.sistema.soil_monitoring.application.decorator;

import com.sistema.soil_monitoring.application.service.SoilService;
import com.sistema.soil_monitoring.domain.model.Soil;

import java.util.List;
import java.util.Optional;

public abstract class SoilServiceDecorator implements SoilService {
    protected final SoilService soilService;

    public SoilServiceDecorator(SoilService soilService) {
        this.soilService = soilService;
    }

    @Override
    public Soil save(Soil soil){
        return soilService.save(soil);
    }

    @Override
    public List<Soil> listAll(){
        return soilService.listAll();
    }


    @Override
    public Optional<Soil> findById(Long id) {
        return soilService.findById(id);
    }

    @Override
    public Soil partialUpdate(Long id, Soil updatedFields ){
        return soilService.partialUpdate(id, updatedFields);
    }

    @Override
    public Soil update(Long id, Soil updatedSoil) {
        return soilService.update(id, updatedSoil);
    }

    @Override
    public void delete(Long id) {
        soilService.delete(id);
    }

}
