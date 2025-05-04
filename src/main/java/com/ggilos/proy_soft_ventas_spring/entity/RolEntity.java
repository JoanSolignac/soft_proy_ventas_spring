package com.ggilos.proy_soft_ventas_spring.entity;

import com.ggilos.proy_soft_ventas_spring.enums.RolEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"usuarios"})
@EqualsAndHashCode
@Table(name = "rol")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_Id")
    private Long id;

    @Column(name = "rol_Nombre", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private RolEnum rol;


    //Relación Rol con Usuarios
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioEntity> usuarios = new ArrayList<>();
}
