package com.sistema.soil_monitoring.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Soil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String ubication;
    private double ph;
    private double moisture;

    //atributos para nutrientes
    private double nitrogen;
    private double phosphorus;
    private double potassium;

    //materia orgánica y nivel de contaminantes
    private double organicMatter;
    private double contaminantLevel;

    // clasificaion de suelo
    private String classification;

    private String managementRecommendation;

    public  Long getId(){
        return id;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getMoisture() {
        return moisture;
    }

    public void setMoisture(double moisture) {
        this.moisture = moisture;
    }

    public double getNitrogen() {
        return nitrogen;
    }

    public void setNitrogen(double nitrogen) {
        this.nitrogen = nitrogen;
    }

    public double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getOrganicMatter() {
        return organicMatter;
    }

    public void setOrganicMatter(double organicMatter) {
        this.organicMatter = organicMatter;
    }

    public double getContaminantLevel() {
        return contaminantLevel;
    }

    public void setContaminantLevel(double contaminantLevel) {
        this.contaminantLevel = contaminantLevel;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getManagementRecommendation() {
        return managementRecommendation;
    }

    public void setManagementRecommendation(String managementRecommendation) {
        this.managementRecommendation = managementRecommendation;
    }
}
