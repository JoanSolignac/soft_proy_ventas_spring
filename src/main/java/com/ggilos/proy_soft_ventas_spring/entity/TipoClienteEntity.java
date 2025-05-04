package com.ggilos.proy_soft_ventas_spring.entity;

import com.ggilos.proy_soft_ventas_spring.enums.TipoClienteEnum;
import jakarta.persistence.*;
import lombok.*;

import java.awt.image.ImagingOpException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tipo_Cliente")
public class TipoClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_Cliente_Id")
    private Long id;

    @Column(name = "tipo_Cliente_Nombre")
    @Enumerated(EnumType.STRING)
    private TipoClienteEnum tipoCliente;

    @OneToMany(mappedBy = "tipoCliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClienteEntity> clientes = new ArrayList<>();
}
