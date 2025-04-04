package com.sistema.soil_monitoring.application.decorator;

import com.sistema.soil_monitoring.application.service.SoilService;
import com.sistema.soil_monitoring.domain.model.Soil;

public class ContaminantValidatorDecorator extends SoilServiceDecorator{

    public ContaminantValidatorDecorator(SoilService soilService) {
        super(soilService);
    }

    @Override
    public Soil save(Soil soil) {
        if (soil.getContaminantLevel() > 50) {
            throw new IllegalArgumentException("El nivel de contaminantes no debe exceder 50");
        }
        return super.save(soil);
    }

}
