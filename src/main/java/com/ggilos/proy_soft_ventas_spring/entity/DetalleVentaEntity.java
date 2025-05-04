package com.ggilos.proy_soft_ventas_spring.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "detalle_Ventas")
public class DetalleVentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_Venta_Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venta_Id", nullable = false)
    private VentaEntity venta;

    @ManyToOne
    @JoinColumn(name = "producto_Id", nullable = false)
    private ProductoEntity producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "subtotal", nullable = false)
    private double subtotal;
}
