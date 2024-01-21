package com.banquito.core.banking.cliente.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.core.banking.cliente.dao.ClienteRepository;
import com.banquito.core.banking.cliente.domain.Cliente;

@Service
public class ClienteService {
    public final ClienteRepository clienteRepository;

        public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

        public List<Cliente> listarTodo(){
        return clienteRepository.findAll(); 
    }

}
