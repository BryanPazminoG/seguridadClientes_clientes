package com.banquito.core.banking.seguridadcliente.services;

import com.banquito.core.banking.seguridadcliente.dao.ClienteRepository;
import com.banquito.core.banking.seguridadcliente.domain.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service

public class ClienteService {
/*
    private final ClienteRepository clienteRepository;
    //private final BCryptPasswordEncoder passwordEncoder;


    public ClienteService(ClienteRepository clienteRepository, BCryptPasswordEncoder passwordEncoder) {
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Cliente autentificacionCliente(String usuario, String contrasenia) {
        try {
            Cliente cliente = clienteRepository.findByUsuario(usuario);

            if (cliente != null && passwordEncoder.matches(contrasenia, cliente.getContrasenia())) {
                return cliente;
            } else {
                throw new RuntimeException("No existe el cliente o la contraseña no coincide");
            }
        } catch (Exception e) {
            throw new CreacionException("Error en autenticación del cliente: " + usuario + ", Error: " + e, e);
        }
    }

    @Transactional
    public void crearMFA(Integer codCliente, String nuevoMFA) {
        try {
            Cliente cliente = clienteRepository.findByCodCliente(codCliente);
            if (cliente != null) {
                cliente.setMfa(nuevoMFA);
                clienteRepository.save(cliente);
            } else {
                throw new RuntimeException("No se encontró el cliente con código: " + codCliente);
            }
        } catch (Exception e) {
            throw new CreacionException("Error al actualizar MFA para el cliente con código: " + codCliente, e);
        }
    }*/
}