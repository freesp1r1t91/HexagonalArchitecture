package com.example.hexagonalorders.domain.port.out;

import com.example.hexagonalorders.domain.model.Delivery;
import com.example.hexagonalorders.domain.model.valueobject.DeliveryNumber;
import java.util.List;
import java.util.Optional;

public interface DeliveryRepository {
    /**
    * Saves an delivery
    * @param delivery the delivery to save
    * @return the saved delivery
    */
    Delivery save(Delivery delivery);

    /**
     * Finds an delivery by its delivery number
     * @param deliveryNumber the delivery number
     * @return the delivery if found
     */
    Optional<Delivery> findByDeliveryNumber(DeliveryNumber deliveryNumber);

    /**
     * Retrieves all deliverys
     * @return list of all deliverys
     */
    List<Delivery> findAll();

    /**
     * Deletes an delivery by its delivery number
     * @param deliveryNumber the delivery number
     */
    void deleteByDeliveryNumber(DeliveryNumber deliveryNumber);
} 