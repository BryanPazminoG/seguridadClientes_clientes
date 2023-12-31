package com.banquito.core.banking.seguridadcliente.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;



@Table(name="ClienteVista")
@Entity
@Getter @Setter
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

    @Version
    private Long version;

    public ClienteVista() {
    }

    public ClienteVista(Cliente cliente, Vista vista, String estado, Long intentosError, Date fechaCreacion,
            Date fechaUltimaModificacion, Long version) {
        this.cliente = cliente;
        this.vista = vista;
        this.estado = estado;
        this.intentosError = intentosError;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
        ClienteVista other = (ClienteVista) obj;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClienteVista [cliente=" + cliente + ", vista=" + vista + ", estado=" + estado + ", intentosError="
                + intentosError + ", fechaCreacion=" + fechaCreacion + ", fechaUltimaModificacion="
                + fechaUltimaModificacion + ", version=" + version + "]";
    }

    
}
