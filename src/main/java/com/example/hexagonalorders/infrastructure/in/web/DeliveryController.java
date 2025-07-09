package com.example.hexagonalorders.infrastructure.in.web;

import com.example.hexagonalorders.application.service.DeliveryService;
import com.example.hexagonalorders.infrastructure.in.web.dto.DeliveryDto;
import com.example.hexagonalorders.infrastructure.in.web.mapper.DeliveryMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import com.example.hexagonalorders.domain.model.Delivery;
import com.example.hexagonalorders.domain.model.valueobject.DeliveryNumber;
import com.example.hexagonalorders.domain.port.in.DeliveryUseCase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for delivery operations.
 * This is an input adapter in the infrastructure layer that handles HTTP requests
 * and delegates to the application core through the DeliveryUseCase port.
 */
@RestController
@RequestMapping("/api/deliveries")
@RequiredArgsConstructor
@Tag(name = "Orders", description = "Order management API")
public class DeliveryController {
    private final DeliveryUseCase deliveryUseCase;
    private final DeliveryMapper deliveryMapper;

    @Operation(summary = "Create a new delivery", description = "Creates a new delivery and returns the created dlivery.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Delivery created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<DeliveryDto> createDelivery(@RequestBody DeliveryDto deliveryDto) {
        Delivery delivery = deliveryMapper.toDomain(deliveryDto);
        Delivery created = deliveryUseCase.createDelivery(delivery);
        return ResponseEntity.ok(deliveryMapper.toDto(created));
    }

    @Operation(summary = "Get an delivery by delivery number", description = "Retrieves an delivery by its delivery number.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Delivery found"),
        @ApiResponse(responseCode = "404", description = "Delivery not found")
    })
    @GetMapping("/{deliveryNumber}")
    public ResponseEntity<DeliveryDto> getDelivery(@PathVariable String deliveryNumber) {
        return deliveryUseCase.getDelivery(new DeliveryNumber(deliveryNumber))
                .map(deliveryMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a delivery by delivery number", description = "Deletes an delivery by its delivery number.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Delivery deleted successfully")
    })
    @DeleteMapping("/{deliveryNumber}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable String deliveryNumber) {
        deliveryUseCase.deleteDelivery(new DeliveryNumber(deliveryNumber));
        return ResponseEntity.noContent().build();
    }
} 