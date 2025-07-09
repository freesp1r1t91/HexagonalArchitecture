package com.example.hexagonalorders.domain.model.valueobject;

/**
 * Value object representing an order number.
 * This encapsulates the business rules and validation for order numbers.
 */
public record DeliveryNumber(String value) {
    public DeliveryNumber {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Order number cannot be null or empty");
        }
    }

    @Override
    public String toString() {
        return value;
    }
} 