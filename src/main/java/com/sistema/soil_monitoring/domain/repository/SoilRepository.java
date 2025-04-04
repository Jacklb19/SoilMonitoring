package com.sistema.soil_monitoring.domain.repository;

import com.sistema.soil_monitoring.domain.model.Soil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilRepository extends JpaRepository<Soil, Long> {
}
