package com.example.hexagonalorders.infrastructure.out.persistence.repository;

import com.example.hexagonalorders.domain.model.Delivery;
import com.example.hexagonalorders.domain.model.valueobject.DeliveryNumber;
import com.example.hexagonalorders.domain.port.out.DeliveryRepository;
import com.example.hexagonalorders.infrastructure.out.persistence.entity.DeliveryJpaEntity;
import com.example.hexagonalorders.infrastructure.out.persistence.mapper.DeliveryJpaMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class DeliveryRepositoryAdapter implements DeliveryRepository {
    private final DeliveryJpaRepository deliveryJpaRepository;
    private final DeliveryJpaMapper deliveryJpaMapper;

    public DeliveryRepositoryAdapter(DeliveryJpaRepository deliveryJpaRepository, DeliveryJpaMapper deliveryJpaMapper) {
        this.deliveryJpaRepository = deliveryJpaRepository;
        this.deliveryJpaMapper = deliveryJpaMapper;
    }

    @Override
    public Delivery save(Delivery delivery) {
        DeliveryJpaEntity entity = deliveryJpaMapper.toJpaEntity(delivery);
        DeliveryJpaEntity saved = deliveryJpaRepository.save(entity);
        return deliveryJpaMapper.toDomain(saved);
    }

    @Override
    public Optional<Delivery> findByDeliveryNumber(DeliveryNumber deliveryNumber) {
        return deliveryJpaRepository.findByDeliveryNumber(deliveryNumber.value())
                .map(deliveryJpaMapper::toDomain);
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryJpaRepository.findAll().stream()
                .map(deliveryJpaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByDeliveryNumber(DeliveryNumber deliveryNumber) {
        deliveryJpaRepository.deleteByDeliveryNumber(deliveryNumber.value());
    }
} 