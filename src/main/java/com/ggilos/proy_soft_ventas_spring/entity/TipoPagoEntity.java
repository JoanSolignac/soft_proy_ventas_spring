package com.ggilos.proy_soft_ventas_spring.entity;

import com.ggilos.proy_soft_ventas_spring.enums.TipoPagoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"ventas"})
@EqualsAndHashCode
@Table(name = "tipo_Pago")
public class TipoPagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_Pago_Id")
    private Long id;

    @Column(name = "tipo_Pago_Nombre", nullable = false, unique = true)
    private TipoPagoEnum tipoPagoEnum;

    //Relación TipoDePago con Venta
    @OneToMany(mappedBy = "tipoPago", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VentaEntity> ventas = new ArrayList<>();
}
