package com.example.hexagonalorders.domain.port.out;

import com.example.hexagonalorders.domain.model.valueobject.DeliveryNumber;

/**
 * Output port defining the contract for delivery number generation.
 * This interface is part of the domain layer and defines how the domain
 * expects to generate unique delivery numbers.
 * 
 * Implementations of this port should be provided by the adapter layer
 * (e.g., using UUID, sequence numbers, etc.).
 */

public interface DeliveryNumberGenerator {
    DeliveryNumber generate();
} 