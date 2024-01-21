package com.banquito.core.banking.cliente.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.banking.cliente.domain.Cliente;
import com.banquito.core.banking.cliente.service.ClienteService;

@RestController
@RequestMapping("/cliente")

public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public List<Cliente> buscarTodas(){
        return clienteService.listarTodo();
    }


}
