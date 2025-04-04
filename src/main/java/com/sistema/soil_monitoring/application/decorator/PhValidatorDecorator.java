package com.sistema.soil_monitoring.application.decorator;

import com.sistema.soil_monitoring.application.service.SoilService;
import com.sistema.soil_monitoring.domain.model.Soil;

public class PhValidatorDecorator extends SoilServiceDecorator {

    public PhValidatorDecorator(SoilService soilService) {
        super(soilService);
    }

    @Override
    public Soil save(Soil soil){
        if (soil.getPh() < 0 || soil.getPh() > 14) {
            throw new IllegalArgumentException("El pH del suelo debe estar entre 0 y 14");
        }
        return super.save(soil);
    }

}
