package com.sistema.soil_monitoring.application.decorator;

import com.sistema.soil_monitoring.application.service.SoilService;
import com.sistema.soil_monitoring.domain.model.Soil;

public class SoilClassificationDecorator extends SoilServiceDecorator{

    public SoilClassificationDecorator(SoilService soilService) {
        super(soilService);
    }

    private void classifySoil(Soil soil) {
        String acidity;
        if (soil.getPh() < 5.5) {
            acidity = "Ácido";
        } else if (soil.getPh() <= 7.5) {
            acidity = "Neutro";
        } else {
            acidity = "Alcalino";
        }

        String moistureStatus;
        if (soil.getMoisture() < 40) {
            moistureStatus = "Seco";
        } else if (soil.getMoisture() <= 70) {
            moistureStatus = "Moderadamente húmedo";
        } else {
            moistureStatus = "Húmedo";
        }

        double avgNutrients = (soil.getNitrogen() + soil.getPhosphorus() + soil.getPotassium()) / 3.0;
        String nutrientStatus;
        if (avgNutrients < 30) {
            nutrientStatus = "Pobre en nutrientes";
        } else if (avgNutrients < 70) {
            nutrientStatus = "Nutrientes balanceados";
        } else {
            nutrientStatus = "Rico en nutrientes";
        }

        String organicMatterStatus;
        if (soil.getOrganicMatter() < 5) {
            organicMatterStatus = "Materia orgánica muy baja";
        } else if (soil.getOrganicMatter() <= 10) {
            organicMatterStatus = "Materia orgánica óptima";
        } else {
            organicMatterStatus = "Exceso de materia orgánica";
        }

        String contaminantStatus;
        if (soil.getContaminantLevel() > 35) {
            contaminantStatus = "Contaminado";
        } else {
            contaminantStatus = "Limpio";
        }

        String classification = acidity + ", " + moistureStatus + ", "
                + nutrientStatus + ", " + organicMatterStatus + ", " + contaminantStatus;
        soil.setClassification(classification);
    }

    @Override
    public Soil save(Soil soil) {
        classifySoil(soil);
        return super.save(soil);
    }

    @Override
    public Soil update(Long id, Soil updatedSoil) {
        classifySoil(updatedSoil);
        return super.update(id, updatedSoil);
    }

    @Override
    public Soil partialUpdate(Long id, Soil updatedSoil) {
        Soil updatedRecord = super.partialUpdate(id, updatedSoil);
        classifySoil(updatedRecord);
        return super.update(id, updatedRecord);
    }

}
