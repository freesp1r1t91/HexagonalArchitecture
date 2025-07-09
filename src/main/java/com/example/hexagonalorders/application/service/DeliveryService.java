package com.example.hexagonalorders.application.service;

import com.example.hexagonalorders.domain.model.Delivery;
import com.example.hexagonalorders.domain.model.valueobject.DeliveryNumber;
import com.example.hexagonalorders.domain.port.in.DeliveryUseCase;
import com.example.hexagonalorders.domain.port.out.DeliveryRepository;
import com.example.hexagonalorders.domain.port.out.DeliveryNumberGenerator;
import com.example.hexagonalorders.domain.service.DeliveryValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;
import java.util.Optional;


/**
 * Application service implementing the delivery-related use cases.
 * This class orchestrates domain logic and coordinates with output ports.
 * It is part of the application layer and is responsible for:
 * - Implementing use cases defined by the domain
 * - Coordinating between domain objects and services
 * - Managing transactions and use case flow
 */

 @RequiredArgsConstructor
public class DeliveryService implements DeliveryUseCase {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryNumberGenerator deliveryNumberGenerator;
    private final DeliveryValidationService deliveryValidationService;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public Delivery createDelivery(Delivery delivery) {
        deliveryValidationService.validate(delivery);
        
        DeliveryNumber deliverNumber = deliveryNumberGenerator.generate();
        Delivery deliveryWithNumber = new Delivery(
            deliverNumber,
            delivery.getDeliveryAddress(),
            delivery.getDeliveryDate(), 
            delivery.getRouteId(),
            delivery.getRepartidorId()
            ); 
        Delivery savedDelivery = deliveryRepository.save(deliveryWithNumber);

        savedDelivery.getDomainEvents().forEach(eventPublisher::publishEvent);
        savedDelivery.clearDomainEvents();

        return savedDelivery;
    }

    @Override
    public Optional<Delivery> getDelivery(DeliveryNumber deliveryNumber) {
        return deliveryRepository.findByDeliveryNumber(deliveryNumber);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public void deleteDelivery(DeliveryNumber deliveryNumber) {
        deliveryRepository.deleteByDeliveryNumber(deliveryNumber);
    }
} 