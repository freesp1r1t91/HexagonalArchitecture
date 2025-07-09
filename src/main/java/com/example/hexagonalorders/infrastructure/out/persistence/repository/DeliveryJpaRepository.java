package com.example.hexagonalorders.infrastructure.out.persistence.repository;

import com.example.hexagonalorders.infrastructure.out.persistence.entity.DeliveryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryJpaRepository extends JpaRepository<DeliveryJpaEntity, Long> {
    Optional<DeliveryJpaEntity> findByDeliveryNumber(String deliveryNumber);
    void deleteByDeliveryNumber(String deliveryNumber);
} 