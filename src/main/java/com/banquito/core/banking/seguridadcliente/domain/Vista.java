package com.banquito.core.banking.seguridadcliente.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "VISTA")


public class Vista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_VISTA", nullable = false)
    private Integer codVista;

    @Column(name = "NOMBRE_VISTA", nullable = false, length = 100)
    private String nombreVista;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaModificacion;

    @Column(name = "VERSION", nullable = false)
    private Long version;
}
