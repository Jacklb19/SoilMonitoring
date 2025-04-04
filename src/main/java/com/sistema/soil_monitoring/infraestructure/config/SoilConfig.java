package com.sistema.soil_monitoring.infraestructure.config;

import com.sistema.soil_monitoring.application.decorator.*;
import com.sistema.soil_monitoring.application.service.SoilService;
import com.sistema.soil_monitoring.application.service.impl.SoilServiceImpl;
import com.sistema.soil_monitoring.domain.model.Soil;
import com.sistema.soil_monitoring.domain.repository.SoilRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoilConfig {
    @Bean

    public SoilService soilService(SoilRepository soilRepository){
        SoilService service = new SoilServiceImpl(soilRepository);

        service = new MoistureValidatorDecorator(service);
        service = new PhValidatorDecorator(service);
        service = new NutrientContentValidatorDecorator(service);
        service = new OrganicMatterValidatorDecorator(service);
        service = new ContaminantValidatorDecorator(service);
        service = new SoilClassificationDecorator(service);
        service = new SoilManagementRecommendationDecorator(service);
        service = new MetricsMonitoringDecorator(service);
        return service;

    }
}
