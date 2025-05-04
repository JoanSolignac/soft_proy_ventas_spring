package com.ggilos.proy_soft_ventas_spring.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"rol", "empleado"})
@EqualsAndHashCode
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "usuario_Id")
    private long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    //Relación Usuario con Rol
    @ManyToOne
    @JoinColumn(name = "rol_Id")
    private RolEntity rol;

    //Relacion de uno a uno de UsuarioEntity a EmpleadoEntity
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private EmpleadoEntity empleado;
}
