package com.banquito.core.banking.seguridadcliente.domain;

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

import java.sql.Date;


@Table(name="Cliente")
@Entity
@Getter @Setter
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

    @Version
    private Long version;

    public Cliente() {
    }

    public Cliente(Integer codCliente, String usuario, String contrasenia, String mfa, Date fechaCreacion,
            Date fechaUltimaModificacion, Long version) {
        this.codCliente = codCliente;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.mfa = mfa;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codCliente == null) ? 0 : codCliente.hashCode());
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
        Cliente other = (Cliente) obj;
        if (codCliente == null) {
            if (other.codCliente != null)
                return false;
        } else if (!codCliente.equals(other.codCliente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [codCliente=" + codCliente + ", usuario=" + usuario + ", contrasenia=" + contrasenia + ", mfa="
                + mfa + ", fechaCreacion=" + fechaCreacion + ", fechaUltimaModificacion=" + fechaUltimaModificacion
                + ", version=" + version + "]";
    }

    
}
