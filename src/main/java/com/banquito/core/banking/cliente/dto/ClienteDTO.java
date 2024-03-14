package com.banquito.core.banking.cliente.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import com.banquito.core.banking.cliente.domain.CodigoVerificacion;
import com.banquito.core.banking.cliente.domain.Permisos;

@Data
@Builder
public class ClienteDTO {

    private String codCliente;
    private String nombreUsuario;
    private String clave;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaModificacion;
    private LocalDateTime fechaUltimoAcceso;
    private String tipoCliente;
    private CodigoVerificacion codigoVerificacion;
    private Permisos permisos;


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
        ClienteDTO other = (ClienteDTO) obj;
        if (codCliente == null) {
            if (other.codCliente != null)
                return false;
        } else if (!codCliente.equals(other.codCliente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClienteDTO [codCliente=" + codCliente + ", nombreUsuario=" + nombreUsuario + ", clave=" + clave
                + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion + ", fechaUltimaModificacion="
                + fechaUltimaModificacion + ", fechaUltimoAcceso=" + fechaUltimoAcceso + ", tipoCliente=" + tipoCliente
                + ", codigoVerificacion=" + codigoVerificacion + ", permisos=" + permisos + "]";
    }

}