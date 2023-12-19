package com.banquito.core.banking.seguridadcliente.domain;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaCreacion;

    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaUltimoCambio;

    @Version
    private Long version;
}