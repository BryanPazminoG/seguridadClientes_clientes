package com.banquito.core.banking.seguridadcliente.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Table(name="ClienteVista")
@Entity
@Getter
@Setter
public class ClienteVista {
    @Id
    @ManyToOne
    @JoinColumn(name = "COD_CLIENTE", nullable = false)
    private Cliente cliente;

    @Id
    @ManyToOne
    @JoinColumn(name = "COD_VISTA", nullable = false)
    private Vista vista;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "INTENTOS_ERROR")
    private Long intentosError;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaModificacion;

    @Column(name = "VERSION", nullable = false)
    private Long version;

    // Getters y setters
}
