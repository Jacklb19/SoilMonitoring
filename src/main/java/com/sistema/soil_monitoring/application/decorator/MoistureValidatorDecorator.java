package com.sistema.soil_monitoring.application.decorator;

import com.sistema.soil_monitoring.application.service.SoilService;
import com.sistema.soil_monitoring.domain.model.Soil;

public class MoistureValidatorDecorator extends SoilServiceDecorator {

    public MoistureValidatorDecorator(SoilService soilService) {
        super(soilService);
    }

    @Override
    public Soil save(Soil soil){

        if (soil.getMoisture() < 0 || soil.getMoisture() > 100 ){
            throw new IllegalArgumentException("El nivel de humedad debe estar entre 0% y 100%");
        }
        return super.save(soil);
    }

}
