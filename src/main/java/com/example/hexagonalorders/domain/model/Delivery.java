package com.example.hexagonalorders.domain.model;

import com.example.hexagonalorders.domain.event.DomainEvent;
import com.example.hexagonalorders.domain.model.valueobject.DeliveryAddress;
import com.example.hexagonalorders.domain.model.valueobject.DeliveryNumber;
import com.example.hexagonalorders.domain.model.valueobject.RouteId;
import com.example.hexagonalorders.domain.model.valueobject.RepartidorId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Delivery {


    private final DeliveryNumber deliveryNumber;
    private final DeliveryAddress deliveryAddress;
    private final LocalDateTime deliveryDate;
    private final RouteId routeId;
    private final RepartidorId repartidorId;
    private final List<DomainEvent> domainEvents = new ArrayList<>();


    public Delivery(DeliveryNumber deliveryNumber, DeliveryAddress deliveryAddress, LocalDateTime deliveryDate, RouteId routeId, RepartidorId deliveryPersonId) {
        if(deliveryNumber == null){
            throw new IllegalArgumentException("Delivery number cannot be null");
        }
        if (deliveryAddress == null) {
            throw new IllegalArgumentException("Delivery address cannot be null");
        }
        if (deliveryDate == null) {
            throw new IllegalArgumentException("Delivery date cannot be null");
        }
        if (routeId == null) {
            throw new IllegalArgumentException("Route id cannot be null");
        }
        if (deliveryPersonId == null) {
            throw new IllegalArgumentException("Delivery person id cannot be null");
        }
        this.deliveryNumber = deliveryNumber;
        this.deliveryAddress = deliveryAddress;
        this.deliveryDate = deliveryDate;
        this.routeId = routeId;
        this.repartidorId = deliveryPersonId;
    }

    public DeliveryNumber getDeliveryNumber(){
        return deliveryNumber;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public RouteId getRouteId() {
        return routeId;
    }

    public RepartidorId getRepartidorId() {
        return repartidorId;
    }

    public List<DomainEvent> getDomainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }

    public void clearDomainEvents() {
        domainEvents.clear();
    }

} 