package com.ggilos.proy_soft_ventas_spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "venta")
public class VentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venta_Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_Pago_Id", nullable = false)
    private TipoPagoEntity tipoPago;

    @ManyToOne
    @JoinColumn(name = "cliente_Id", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "empleado_Id", nullable = false)
    private EmpleadoEntity empleado;

    @Column(name = "venta_Fecha", nullable = false)
    private Date fecha;

    @Column(name = "venta_total", nullable = false)
    private Double total;

    //Relación de Venta con DetalleVenta
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVentaEntity> detalleVentas = new ArrayList<>();
}
