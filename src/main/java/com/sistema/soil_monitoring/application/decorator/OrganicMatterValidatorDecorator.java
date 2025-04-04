package com.sistema.soil_monitoring.application.decorator;

import com.sistema.soil_monitoring.application.service.SoilService;
import com.sistema.soil_monitoring.domain.model.Soil;

public class OrganicMatterValidatorDecorator extends SoilServiceDecorator{

    public OrganicMatterValidatorDecorator(SoilService soilService) {
        super(soilService);
    }

    @Override
    public Soil save(Soil soil) {
        if (soil.getOrganicMatter() < 1 || soil.getOrganicMatter() > 15) {
            throw new IllegalArgumentException("El porcentaje de materia orgánica debe estar entre 1% y 15%");
        }
        return super.save(soil);
    }


}
