package com.ggilos.proy_soft_ventas_spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "catProducto")
@EqualsAndHashCode
@Table(name = "producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cat_Producto_Id", nullable = false)
    private CatProductoEntity catProducto;

    @Column(name = "producto_Nombre", nullable = false, unique = true, length = 255)
    private String nombreProducto;

    @Column(name = "producto_Stock", nullable = false)
    private int stockProducto;

    @Column(name = "producto_Precio", nullable = false)
    private double precioProducto;

    //Relación de Producto con DetalleVentas
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVentaEntity> detalleVentas = new ArrayList<>();
}
