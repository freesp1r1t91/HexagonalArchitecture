package com.example.hexagonalorders.infrastructure.out.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "deliveries")
public class DeliveryJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String deliveryNumber;

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String colonia;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private LocalDateTime deliveryDate;

    @Column(nullable = false)
    private String routeId;

    @Column(nullable = false)
    private String repartidorId;

    public DeliveryJpaEntity() {}

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeliveryNumber() { return deliveryNumber; }
    public void setDeliveryNumber(String deliveryNumber) { this.deliveryNumber = deliveryNumber; }

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getColonia() { return colonia; }
    public void setColonia(String colonia) { this.colonia = colonia; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public LocalDateTime getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(LocalDateTime deliveryDate) { this.deliveryDate = deliveryDate; }

    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }

    public String getRepartidorId() { return repartidorId; }
    public void setRepartidorId(String repartidorId) { this.repartidorId = repartidorId; }
} 