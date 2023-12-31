package com.banquito.core.banking.seguridadcliente.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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

    @Version
    private Long version;

    public Vista() {
    }

    public Vista(Integer codVista, String nombreVista, Date fechaCreacion, Date fechaUltimaModificacion, Long version) {
        this.codVista = codVista;
        this.nombreVista = nombreVista;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codVista == null) ? 0 : codVista.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vista other = (Vista) obj;
        if (codVista == null) {
            if (other.codVista != null)
                return false;
        } else if (!codVista.equals(other.codVista))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vista [codVista=" + codVista + ", nombreVista=" + nombreVista + ", fechaCreacion=" + fechaCreacion
                + ", fechaUltimaModificacion=" + fechaUltimaModificacion + ", version=" + version + "]";
    }

    
}
