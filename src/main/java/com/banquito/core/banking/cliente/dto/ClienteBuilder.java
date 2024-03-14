package com.banquito.core.banking.cliente.dto;

import com.banquito.core.banking.cliente.domain.Cliente;

public class ClienteBuilder {

    public static Cliente toCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setCodCliente(dto.getCodCliente());
        cliente.setNombreUsuario(dto.getNombreUsuario());
        cliente.setClave(dto.getClave());
        cliente.setEstado(dto.getEstado());
        cliente.setFechaCreacion(dto.getFechaCreacion());
        cliente.setFechaUltimoAcceso(dto.getFechaUltimoAcceso());
        cliente.setTipoCliente(dto.getTipoCliente());
        cliente.setCodigoVerificacion(dto.getCodigoVerificacion());
        cliente.setPermisos(dto.getPermisos());
        return cliente;
    }
    public static Cliente copyCliente(Cliente fuente, Cliente destino){

        if (fuente.getNombreUsuario() != null) {
            destino.setNombreUsuario(fuente.getNombreUsuario());
        }
    
        if (fuente.getClave() != null) {
            destino.setClave(fuente.getClave());
        }
    
        if (fuente.getFechaCreacion() != null) {
            destino.setFechaCreacion(fuente.getFechaCreacion());
        }
    
        if (fuente.getCodCliente() != null) {
            destino.setCodCliente(fuente.getCodCliente());
        }

        if (fuente.getEstado() != null) {
            destino.setEstado(fuente.getEstado());
        }

        if (fuente.getFechaUltimoAcceso() != null) {
            destino.setFechaUltimoAcceso(fuente.getFechaUltimoAcceso());
        }

        if (fuente.getTipoCliente() != null) {
            destino.setTipoCliente(fuente.getTipoCliente());
        }

        if (fuente.getCodigoVerificacion() != null) {
            destino.setCodigoVerificacion(fuente.getCodigoVerificacion());
        }

        if (fuente.getPermisos() != null) {
            destino.setPermisos(fuente.getPermisos());
        }

        return destino;
    }

}
