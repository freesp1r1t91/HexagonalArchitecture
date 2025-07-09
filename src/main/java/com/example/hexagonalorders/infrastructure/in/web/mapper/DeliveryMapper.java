package com.example.hexagonalorders.infrastructure.in.web.mapper;

import org.springframework.stereotype.Component;
import com.example.hexagonalorders.domain.model.Delivery;
import com.example.hexagonalorders.domain.model.valueobject.*;
import com.example.hexagonalorders.infrastructure.in.web.dto.DeliveryDto;

/**
 * Mapper class responsible for converting between domain entities and DTOs.
 * This class is part of the adapter layer and helps maintain
 * the separation between the domain model and the API layer.
 */

 @Component
public class DeliveryMapper {

    public DeliveryDto toDto(Delivery delivery) {
        if (delivery == null) return null;
        DeliveryAddress address = delivery.getDeliveryAddress();
        return new DeliveryDto(
            delivery.getDeliveryNumber().value(),
            delivery.getDeliveryAddress().calle(),
            delivery.getDeliveryAddress().numero(),
            delivery.getDeliveryAddress().colonia(),
            delivery.getDeliveryAddress().ciudad(),
            delivery.getDeliveryAddress().estado(),
            delivery.getDeliveryAddress().pais(),
            delivery.getDeliveryDate(),
            delivery.getRouteId().value(),
            delivery.getRepartidorId().value()
        );
    }

    public Delivery toDomain(DeliveryDto dto) {
        if (dto == null) return null;

        return new Delivery(
            new DeliveryNumber(dto.getDeliveryNumber()),
            new DeliveryAddress(
                dto.getCalle(),
                dto.getNumero(),
                dto.getColonia(),
                dto.getCiudad(),
                dto.getEstado(),
                dto.getPais()
            ),
            dto.getDeliveryDate(),
            new RouteId(dto.getRouteId()),
            new RepartidorId(dto.getRepartidorId())
        );
    }
} 