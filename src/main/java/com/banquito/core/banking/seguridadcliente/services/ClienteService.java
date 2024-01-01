package com.banquito.core.banking.seguridadcliente.services;

import com.banquito.core.banking.seguridadcliente.dao.ClienteRepository;
import com.banquito.core.banking.seguridadcliente.domain.Cliente;

import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente auntenticar(String usuario, String contrasena) {
        return clienteRepository.findByUsuarioAndContrasena(usuario, contrasena);
    }

    @Transactional
    public Cliente crearCliente(Cliente nuevoCliente) {
        return clienteRepository.save(nuevoCliente);
    }

    public Optional<Cliente> bucarPorId(Integer codCliente){
        return clienteRepository.findById(codCliente);
    }

    @Transactional
    public void actualizarAtributosCliente(Integer idCliente, String codigoMfa) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setMfa(codigoMfa);

            clienteRepository.save(cliente); 
        }
    }
}
