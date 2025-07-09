package com.example.hexagonalorders.domain.service;

import com.example.hexagonalorders.domain.model.Delivery;

/**
 * Domain service responsible for validating deliverys according to business rules.
 * This service encapsulates complex validation logic that doesn't naturally fit
 * within the Order entity itself.
 * 
 * As a domain service, it:
 * - Contains business logic that spans multiple entities
 * - Is stateless
 * - Operates purely on domain objects
 * - Is independent of infrastructure concerns
 */

public class DeliveryValidationService {
    /**
     * Valida las reglas de negocio para una entrega (Delivery).
     * Lanza IllegalArgumentException si alguna regla no se cumple.
     */
    public void validate(Delivery delivery) {
        if (delivery == null) {
            throw new IllegalArgumentException("La entrega no puede ser nula");
        }
        if (delivery.getDeliveryAddress() == null) {
            throw new IllegalArgumentException("La dirección de entrega no puede ser nula");
        }
        if (delivery.getDeliveryDate() == null) {
            throw new IllegalArgumentException("La fecha de entrega no puede ser nula");
        }
        if (delivery.getRouteId() == null) {
            throw new IllegalArgumentException("La ruta no puede ser nula");
        }
        if (delivery.getRepartidorId() == null) {
            throw new IllegalArgumentException("El repartidor no puede ser nulo");
        }

    }
} 