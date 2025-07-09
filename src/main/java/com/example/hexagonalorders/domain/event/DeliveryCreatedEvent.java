package com.example.hexagonalorders.domain.event;

import com.example.hexagonalorders.domain.model.valueobject.DeliveryNumber;

/**
 * Event raised when a new delivery is created.
 */

public class DeliveryCreatedEvent extends DomainEvent {
    private final Long deliveryId;
    private final DeliveryNumber deliveryNumber;

    public DeliveryCreatedEvent(Long deliveryId, DeliveryNumber deliveryNumber) {
        super();
        this.deliveryId = deliveryId;
        this.deliveryNumber = deliveryNumber;
    }

    public Long getDeliveryId(){
        return deliveryId;
    }

    public DeliveryNumber getDeliveryNumber() {
        return deliveryNumber;
    }
} 