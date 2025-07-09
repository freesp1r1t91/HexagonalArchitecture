package com.example.hexagonalorders.infrastructure.out.persistence.mapper;

import org.springframework.stereotype.Component;

import com.example.hexagonalorders.domain.model.Delivery;
import com.example.hexagonalorders.domain.model.valueobject.DeliveryAddress;
import com.example.hexagonalorders.domain.model.valueobject.DeliveryNumber;
import com.example.hexagonalorders.domain.model.valueobject.RouteId;
import com.example.hexagonalorders.domain.model.valueobject.RepartidorId;
import com.example.hexagonalorders.infrastructure.out.persistence.entity.DeliveryJpaEntity;

@Component
public class DeliveryJpaMapper {
    public DeliveryJpaEntity toJpaEntity(Delivery delivery) {
        if (delivery == null) return null;
        DeliveryJpaEntity entity = new DeliveryJpaEntity();
        entity.setDeliveryNumber(delivery.getDeliveryNumber().value());
        entity.setCalle(delivery.getDeliveryAddress().calle());
        entity.setNumero(delivery.getDeliveryAddress().numero());
        entity.setColonia(delivery.getDeliveryAddress().colonia());
        entity.setCiudad(delivery.getDeliveryAddress().ciudad());
        entity.setEstado(delivery.getDeliveryAddress().estado());
        entity.setPais(delivery.getDeliveryAddress().pais());
        entity.setDeliveryDate(delivery.getDeliveryDate());
        entity.setRouteId(delivery.getRouteId().value());
        entity.setRepartidorId(delivery.getRepartidorId().value());
        return entity;
    }

    public Delivery toDomain(DeliveryJpaEntity entity) {
        if (entity == null) return null;

        return new Delivery(
            
            new DeliveryNumber(entity.getDeliveryNumber()),
            new DeliveryAddress(
                entity.getCalle(),
                entity.getNumero(),
                entity.getColonia(),
                entity.getCiudad(),
                entity.getEstado(),
                entity.getPais()
            ),
            entity.getDeliveryDate(),
            new RouteId(entity.getRouteId()),
            new RepartidorId(entity.getRepartidorId())
        );
    }
} 