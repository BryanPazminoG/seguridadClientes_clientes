package com.banquito.core.banking.seguridadcliente.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Table(name="Cliente")
@Entity
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CLIENTE", nullable = false)
    private Integer codCliente;

    @Column(name = "USUARIO", nullable = false, length = 100)
    private String usuario;

    @Column(name = "CONTRASENIA", nullable = false, length = 64)
    private String contrasenia;

    @Column(name = "MFA", nullable = false, length = 6)
    private String mfa;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaModificacion;

    @Column(name = "VERSION", nullable = false)
    private Long version;
}
