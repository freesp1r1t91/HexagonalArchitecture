package com.example.hexagonalorders.infrastructure.out.orderNumber;

import com.example.hexagonalorders.domain.model.valueobject.DeliveryNumber;
import com.example.hexagonalorders.domain.port.out.DeliveryNumberGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Secondary adapter implementing the DeliveryNumberGenerator port using UUID.
 * This class is part of the adapter layer and is responsible for:
 * - Generating unique delivery numbers using UUID
 * - Implementing the deliveryNumberGenerator port
 * - Providing a concrete implementation of the delivery number generation strategy
 * 
 * This adapter follows the Adapter pattern to provide a specific implementation
 * of the order number generation strategy while keeping the domain layer
 * independent of the implementation details.
 */
@Component
public class UuidDeliveryNumberGenerator implements DeliveryNumberGenerator {
    @Override
    public DeliveryNumber generate() {
        return new DeliveryNumber(UUID.randomUUID().toString());
    }
} 