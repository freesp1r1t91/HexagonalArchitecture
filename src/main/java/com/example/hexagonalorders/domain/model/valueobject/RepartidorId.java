package com.example.hexagonalorders.domain.model.valueobject;

public record RepartidorId(String value) {
    public RepartidorId {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Delivery person id cannot be null or empty");
        }
    }

    @Override
    public String toString() {
        return value;
    }
} 