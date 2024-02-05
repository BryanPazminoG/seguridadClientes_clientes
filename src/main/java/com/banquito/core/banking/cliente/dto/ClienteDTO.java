package com.banquito.core.banking.cliente.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.cglib.core.Local;

@Data
@Builder
public class ClienteDTO {

    private String codCliente;
    private String usuario;
    private String contrasena;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaModificacion;


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
        return "ClienteDTO [codCliente=" + codCliente + ", usuario=" + usuario + ", contrasena=" + contrasena
                + ", fechaCreacion=" + fechaCreacion + ", fechaUltimaModificacion=" + fechaUltimaModificacion + "]";
    }

}