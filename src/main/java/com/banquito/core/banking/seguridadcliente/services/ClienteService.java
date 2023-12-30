package com.banquito.core.banking.seguridadcliente.services;

import com.banquito.core.banking.seguridadcliente.dao.ClienteRepository;
import com.banquito.core.banking.seguridadcliente.domain.Cliente;
import org.springframework.stereotype.Service;
@Service

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente authenticateCliente(String usuario, String contrasena) {
        return clienteRepository.findByUsuarioAndContrasena(usuario, contrasena);
    }
}
