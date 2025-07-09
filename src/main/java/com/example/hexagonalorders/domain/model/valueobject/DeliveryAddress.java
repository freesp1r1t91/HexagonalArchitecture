package com.example.hexagonalorders.domain.model.valueobject;

public record DeliveryAddress(String calle, String numero, String colonia, String ciudad, String estado, String pais) {
    public DeliveryAddress {
        if (calle == null || calle.trim().isEmpty()) {
            throw new IllegalArgumentException("Calle no puede ser nula o vacía");
        }
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("Número no puede ser nulo o vacío");
        }
        if (colonia == null || colonia.trim().isEmpty()) {
            throw new IllegalArgumentException("Colonia no puede ser nula o vacía");
        }
        if (ciudad == null || ciudad.trim().isEmpty()) {
            throw new IllegalArgumentException("Ciudad no puede ser nula o vacía");
        }
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("Estado no puede ser nulo o vacío");
        }
        if (pais == null || pais.trim().isEmpty()) {
            throw new IllegalArgumentException("Pais no puede ser nulo o vacío");
        }
    }

    @Override
    public String toString() {
        return "Calle: " + calle + ", Número: " + numero + ", Colonia: " + colonia + ", Ciudad: " + ciudad + ", Estado: " + estado + ", Pais: " + pais;
    }

} 