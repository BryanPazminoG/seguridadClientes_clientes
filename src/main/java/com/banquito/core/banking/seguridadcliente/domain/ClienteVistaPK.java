package com.banquito.core.banking.seguridadcliente.domain;



import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
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
    public String toString() {
        return "ClienteVistaPK [codCliente=" + codCliente + ", codVista=" + codVista + "]";
    }

    


}

