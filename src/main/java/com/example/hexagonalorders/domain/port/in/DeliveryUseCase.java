package com.example.hexagonalorders.domain.port.in;

import com.example.hexagonalorders.domain.model.Delivery;
import com.example.hexagonalorders.domain.model.valueobject.DeliveryNumber;
import java.util.List;
import java.util.Optional;

/**
 * Input port defining the contract for delivery operations.
 * This interface is part of the domain layer and defines the core business operations
 * that can be performed on deliveries.
 */
public interface DeliveryUseCase {
    /**
     * Creates a new delivery
     * @param delivery the delivery to create
     * @return the created delivery
     */
    Delivery createDelivery(Delivery delivery);

    /**
     * Retrieves a delivery by its delivery number
     * @param deliveryNumber the delivery number
     * @return the delivery if found
     */
    Optional<Delivery> getDelivery(DeliveryNumber deliveryNumber);

    /**
     * Retrieves all deliveries
     * @return list of all deliveries
     */
    List<Delivery> getAllDeliveries();

    /**
     * Deletes a delivery by its delivery number
     * @param deliveryNumber the delivery number
     */
    void deleteDelivery(DeliveryNumber deliveryNumber);
} 