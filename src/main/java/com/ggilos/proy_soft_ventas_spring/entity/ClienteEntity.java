package com.ggilos.proy_soft_ventas_spring.entity;

import com.ggilos.proy_soft_ventas_spring.enums.TipoClienteEnum;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"tipoCliente"})
@EqualsAndHashCode
@Table(name = "cliente")

public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_Id")
    private Long id;

    @Column(name = "cliente_Nombre", nullable = false, length = 100)
    private String clienteNombre;

    @Column(name = "cliente_Razon_Social", nullable = false)
    private String clienteRazonSocial;

    @Column(name = "cliente_Documento", length = 11, nullable = false, unique = true)
    private String clienteDocumento;

    @Column(name = "cliente_Telefono", length = 9, nullable = false, unique = true)
    private String clienteTelefono;

    @Column(name = "cliente_Fecha_Registro", nullable = false)
    private Date ClienteFechaRegistro;

    //Relación de ClienteEntity a TipoCliente
    @ManyToOne
    @JoinColumn (name = "tipo_Cliente_Id", nullable = false)
    private TipoClienteEntity tipoCliente;

    //Relación de Cliente con Venta
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VentaEntity> ventas = new ArrayList<>();
}
