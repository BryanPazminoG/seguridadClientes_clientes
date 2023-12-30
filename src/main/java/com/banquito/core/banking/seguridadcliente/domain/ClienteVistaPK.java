package com.banquito.core.banking.seguridadcliente.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ClienteVistaPK implements Serializable {
    @Column(name = "COD_CLIENTE", nullable = false)
    private Integer codCliente;
    @Column(name = "COD_VISTA", nullable = false)
    private Integer codVista;

    public ClienteVistaPK() {
    }
    public ClienteVistaPK(Integer codCliente, Integer codVista) {
        this.codCliente = codCliente;
        this.codVista = codVista;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteVistaPK that = (ClienteVistaPK) o;
        return Objects.equals(codCliente, that.codCliente) &&
                Objects.equals(codVista, that.codVista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codCliente, codVista);
    }
}

