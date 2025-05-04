package com.ggilos.proy_soft_ventas_spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"productos"})
@EqualsAndHashCode
@Table(name = "cat_producto")
public class CatProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_Producto_Id")
    private Long id;

    @Column(name = "cat_Producto_Nombre_Categoria", unique = true, nullable = false, length = 255)
    private String nombreCategoria;

    @Column(name = "cat_Producto_Descripcion", nullable = false, length = 255)
    private String descripcion;

    //Relación de CatProducto a Producto
    @OneToMany(mappedBy = "catProducto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoEntity> productos;
}
