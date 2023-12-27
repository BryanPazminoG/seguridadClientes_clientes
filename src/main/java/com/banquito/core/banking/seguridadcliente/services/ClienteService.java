package com.banquito.core.banking.seguridadcliente.services;

import com.banquito.core.banking.seguridadcliente.dao.ClienteRepository;
import com.banquito.core.banking.seguridadcliente.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void createCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void updateCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    // Método personalizado para la autenticación del cliente
    public Cliente authenticateCliente(String usuario, String contrasena) {
        return clienteRepository.findByUsuarioAndContrasena(usuario, contrasena);
    }
}
