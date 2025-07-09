package com.example.hexagonalorders.domain.model.valueobject;

public record RouteId(String value) {
    public RouteId {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Route id cannot be null or empty");
        }
    }

    @Override
    public String toString() {
        return value;
    }
} 