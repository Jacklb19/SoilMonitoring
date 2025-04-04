package com.sistema.soil_monitoring.application.service.impl;

import com.sistema.soil_monitoring.application.service.SoilService;
import com.sistema.soil_monitoring.domain.model.Soil;
import com.sistema.soil_monitoring.domain.repository.SoilRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public class SoilServiceImpl implements SoilService {
    private final SoilRepository soilRepository;

    public SoilServiceImpl(SoilRepository soilRepository) {
        this.soilRepository = soilRepository;
    }

    @Override
    public Soil save(Soil soil){
        return soilRepository.save(soil);
    }

    @Override
    public List<Soil> listAll(){
        return soilRepository.findAll();
    }

    @Override
    public Optional<Soil> findById(Long id){
        return soilRepository.findById(id);
    }

    @Override
    public Soil update(Long id, Soil updateSoil ) {
        return soilRepository.findById(id)
                .map(existingSoil -> {
                    existingSoil.setUbication(updateSoil.getUbication());
                    existingSoil.setPh(updateSoil.getPh());
                    existingSoil.setMoisture(updateSoil.getMoisture());
                    existingSoil.setNitrogen(updateSoil.getNitrogen());
                    existingSoil.setPhosphorus(updateSoil.getPhosphorus());
                    existingSoil.setPotassium(updateSoil.getPotassium());
                    existingSoil.setOrganicMatter(updateSoil.getOrganicMatter());
                    existingSoil.setContaminantLevel(updateSoil.getContaminantLevel());
                    existingSoil.setClassification(updateSoil.getClassification());
                    return soilRepository.save(existingSoil);
                })
                .orElseThrow(() -> new IllegalArgumentException("El suelo con ID " + id + " no existe"));
    }


    @Override
    public Soil partialUpdate(Long id, Soil updatedFields){
        return soilRepository.findById(id)
                .map(existingSoil -> {

                    if (updatedFields.getUbication() != null) {
                        existingSoil.setUbication(updatedFields.getUbication());
                    }
                    if (updatedFields.getPh() != 0){
                        existingSoil.setPh(updatedFields.getPh());
                    }
                    if (updatedFields.getMoisture() != 0){
                        existingSoil.setMoisture(updatedFields.getMoisture());
                    }
                    if (updatedFields.getNitrogen() != 0){
                        existingSoil.setNitrogen(updatedFields.getNitrogen());
                    }
                    if (updatedFields.getPhosphorus() != 0){
                        existingSoil.setPhosphorus(updatedFields.getPhosphorus());
                    }
                    if (updatedFields.getPotassium() != 0){
                        existingSoil.setPotassium(updatedFields.getPotassium());
                    }
                    if (updatedFields.getOrganicMatter() != 0){
                        existingSoil.setOrganicMatter(updatedFields.getOrganicMatter());
                    }
                    if (updatedFields.getContaminantLevel() != 0){
                        existingSoil.setContaminantLevel(updatedFields.getContaminantLevel());
                    }
                    if (updatedFields.getClassification() != null){
                        existingSoil.setClassification(updatedFields.getClassification());
                    }

                    return soilRepository.save(existingSoil);
                })
                .orElseThrow(() -> new IllegalArgumentException("El suelo con ID " + id + " no existe."));
    }


    @Override
    public void delete(Long id){
        if(!soilRepository.existsById(id)){
            throw new IllegalArgumentException("El suelo con ID " + id + " no existe");
        }
        soilRepository.deleteById(id);
    }

}
