package com.banquito.core.banking.seguridadcliente.domain;

import java.io.Serializable;
import java.util.Objects;

public class ClienteVistaPK implements Serializable {

    private Long codCliente;
    private Long codVista;

    public ClienteVistaPK() {
    }

    public ClienteVistaPK(Long codCliente, Long codVista) {
        this.codCliente = codCliente;
        this.codVista = codVista;
    }

    public Long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Long codCliente) {
        this.codCliente = codCliente;
    }

    public Long getCodVista() {
        return codVista;
    }

    public void setCodVista(Long codVista) {
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

