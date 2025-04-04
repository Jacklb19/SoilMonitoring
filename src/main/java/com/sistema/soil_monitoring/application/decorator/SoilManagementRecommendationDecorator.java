package com.sistema.soil_monitoring.application.decorator;

import com.sistema.soil_monitoring.application.service.SoilService;
import com.sistema.soil_monitoring.domain.model.Soil;

public class SoilManagementRecommendationDecorator extends SoilServiceDecorator{

    public SoilManagementRecommendationDecorator(SoilService soilService) {
        super(soilService);
    }

    private void generateRecommendation(Soil soil) {
        StringBuilder recommendation = new StringBuilder();

        if (soil.getPh() < 6.0) {
            recommendation.append("Aplicar cal para elevar el pH. ");
        } else if (soil.getPh() > 7.5) {
            recommendation.append("Aplicar azufre para bajar el pH. ");
        }

        if (soil.getMoisture() < 30) {
            recommendation.append("Aumentar riego. ");
        } else if (soil.getMoisture() > 80) {
            recommendation.append("Reducir riego. ");
        }

        double avgNutrients = (soil.getNitrogen() + soil.getPhosphorus() + soil.getPotassium()) / 3.0;
        if (avgNutrients < 30) {
            recommendation.append("Aplicar fertilizante balanceado. ");
        }

        if (soil.getOrganicMatter() < 5) {
            recommendation.append("Incorporar materia orgánica para mejorar la estructura. ");
        }

        if (soil.getContaminantLevel() > 50) {
            recommendation.append("Realizar acciones de remediación por altos niveles de contaminantes. ");
        }

        if (recommendation.length() == 0) {
            recommendation.append("El suelo se encuentra en condiciones óptimas.");
        }

        soil.setManagementRecommendation(recommendation.toString());
    }

    @Override
    public Soil save(Soil soil){
        generateRecommendation(soil);
        return super.save(soil);
    }

    @Override
    public Soil update(Long id, Soil updateSoil){
        generateRecommendation(updateSoil);
        return super.update(id, updateSoil);
    }

    @Override
    public Soil partialUpdate(Long id, Soil updatedSoil){

        Soil updatedRecord = super.partialUpdate(id, updatedSoil);

        generateRecommendation(updatedSoil);
        return super.partialUpdate(id, updatedRecord);

    }

}
