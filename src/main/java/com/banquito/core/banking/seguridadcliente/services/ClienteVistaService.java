package com.banquito.core.banking.seguridadcliente.services;

import com.banquito.core.banking.seguridadcliente.dao.ClienteVistaRepository;
import com.banquito.core.banking.seguridadcliente.domain.ClienteVista;
import com.banquito.core.banking.seguridadcliente.domain.ClienteVistaPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteVistaService {
    @Autowired
    private ClienteVistaRepository clienteVistaRepository;

    public List<ClienteVista> getAllClienteVistas() {
        return (List<ClienteVista>) clienteVistaRepository.findAll();
    }

    public List<ClienteVista> getClienteVistasByCodClienteAndEstado(Long codCliente, boolean estado) {
        return clienteVistaRepository.findByCodClienteAndEstado(codCliente, estado);
    }

    public void createClienteVista(ClienteVista clienteVista) {
        clienteVistaRepository.save(clienteVista);
    }

    public void updateClienteVista(Long codCliente, Long codVista, ClienteVista clienteVista) {
        clienteVistaRepository.save(clienteVista);
    }

    public void deleteClienteVista(Long codCliente, Long codVista) {
        clienteVistaRepository.deleteById(new ClienteVistaPK(codCliente, codVista));
    }
}
