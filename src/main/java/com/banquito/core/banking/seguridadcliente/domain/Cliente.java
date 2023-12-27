package com.banquito.core.banking.seguridadcliente.domain;

import javax.persistence.*;
import java.util.Date;

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CLIENTE", nullable = false)
    private Long codCliente;

    @Column(name = "USUARIO", nullable = false, length = 100)
    private String usuario;

    @Column(name = "CONTRASENA", nullable = false, length = 64)
    private String contrasena;

    @Column(name = "MFA", nullable = false, length = 6)
    private String mfa;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "FECHA_ULTIMA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaCreacion;

    @Column(name = "VERSION", nullable = false)
    private Long version;
}
