package com.banquito.core.banking.cliente.dto;

import com.banquito.core.banking.cliente.domain.Cliente;

public class ClienteBuilder {

    public static Cliente toCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setCodCliente(dto.getCodCliente());
        cliente.setUsuario(dto.getUsuario());
        cliente.setContrasena(dto.getContrasena());
        cliente.setFechaCreacion(dto.getFechaCreacion());

        return cliente;
    }
    public static Cliente copyCliente(Cliente fuente, Cliente destino){

        if (fuente.getUsuario() != null) {
            destino.setUsuario(fuente.getUsuario());
        }
    
        if (fuente.getContrasena() != null) {
            destino.setContrasena(fuente.getContrasena());
        }
    
        if (fuente.getFechaCreacion() != null) {
            destino.setFechaCreacion(fuente.getFechaCreacion());
        }
    
        if (fuente.getCodCliente() != null) {
            destino.setCodCliente(fuente.getCodCliente());
        }

        return destino;
    }

}
