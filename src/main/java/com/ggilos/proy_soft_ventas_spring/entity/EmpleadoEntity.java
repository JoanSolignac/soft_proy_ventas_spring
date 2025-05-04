package com.ggilos.proy_soft_ventas_spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"usuario"})
@EqualsAndHashCode
@Table(name = "empleado")

public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_Empleado")
    private String empleadoNombre;

    @Column(name = "apellido_Empleado")
    private String empleadoApellido;

    @Column(name = "empleado_Dni", length = 8)
    private String empleadoDni;

    //Relacion de uno a uno  a EmpleadoEntity a UsuarioEntity
    @OneToOne
    @JoinColumn(name= "usuario_Id", nullable = false)
    private UsuarioEntity usuario;

    //Relación de Empleado con Venta
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VentaEntity> ventas = new ArrayList<>();

}
