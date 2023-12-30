package com.banquito.core.banking.seguridadcliente.services;

import com.banquito.core.banking.seguridadcliente.dao.ClienteVistaRepository;
import com.banquito.core.banking.seguridadcliente.domain.ClienteVista;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteVistaService {

    private ClienteVistaRepository clienteVistaRepository;

    public ClienteVistaService(ClienteVistaRepository clienteVistaRepository) {
        this.clienteVistaRepository = clienteVistaRepository;
    }

    public List<ClienteVista> getClienteVistasByCodClienteAndEstado(Integer codCliente, String estado) {
        return clienteVistaRepository.findByCodClienteAndEstado(codCliente, estado);
    }


}
