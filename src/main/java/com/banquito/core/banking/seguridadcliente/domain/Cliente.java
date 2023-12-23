package com.banquito.core.banking.seguridadcliente.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CLIENTE", nullable = false)
    private Integer codCliente;

    @Column(name = "USUARIO", nullable = false)
    private String usuario;

    @Column(name = "CONTRASEÑA", nullable = false)
    private String contraseña;

    @Column(name = "MFA", nullable = false)
    private String mfa;

    @Column(name = "FECHA_CREACION", nullable = false)
    private Instant fechaCreacion;

    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
    private Instant fechaUltimoCambio;

    @Column(name = "ACTIVO", nullable = false)
    private boolean activo;  // Nuevo campo para indicar si el cliente está activo o inactivo

    @Version
    private Long version;
}
