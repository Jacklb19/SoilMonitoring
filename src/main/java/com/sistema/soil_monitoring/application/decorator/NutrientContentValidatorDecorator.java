package com.sistema.soil_monitoring.application.decorator;

import com.sistema.soil_monitoring.application.service.SoilService;
import com.sistema.soil_monitoring.domain.model.Soil;

public class NutrientContentValidatorDecorator extends SoilServiceDecorator {

    public NutrientContentValidatorDecorator(SoilService soilService) {
        super(soilService);
    }

    public Soil save(Soil soil) {
        if (soil.getNitrogen() < 0 || soil.getNitrogen() > 100) {
            throw new IllegalArgumentException("El nivel de nitrógeno debe estar entre 0 y 100");
        }
        if (soil.getPhosphorus() < 0 || soil.getPhosphorus() > 100) {
            throw new IllegalArgumentException("El nivel de fósforo debe estar entre 0 y 100");
        }
        if (soil.getPotassium() < 0 || soil.getPotassium() > 100) {
            throw new IllegalArgumentException("El nivel de potasio debe estar entre 0 y 100");
        }
        return super.save(soil);
    }
}
