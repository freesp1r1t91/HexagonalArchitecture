package com.example.hexagonalorders.infrastructure.config;

import com.example.hexagonalorders.application.service.DeliveryService;
import com.example.hexagonalorders.domain.port.out.DeliveryRepository;
import com.example.hexagonalorders.domain.port.out.DeliveryNumberGenerator;
import com.example.hexagonalorders.domain.service.DeliveryValidationService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for delivery-related beans.
 * This class is part of the infrastructure layer and is responsible for:
 * - Wiring together domain, application, and adapter components
 * - Managing infrastructure concerns
 * - Providing Spring beans for dependency injection
 */

@Configuration
public class DeliveryConfiguration {

    @Bean
    public DeliveryService deliveryService(
            DeliveryRepository deliveryRepository,
            DeliveryNumberGenerator deliveryNumberGenerator,
            DeliveryValidationService deliveryValidationService,
            ApplicationEventPublisher eventPublisher
    ) {
        return new DeliveryService(
                deliveryRepository,
                deliveryNumberGenerator,
                deliveryValidationService,
                eventPublisher
        );
    }

    @Bean
    public DeliveryValidationService deliveryValidationService() {
        return new DeliveryValidationService();
    }
} 