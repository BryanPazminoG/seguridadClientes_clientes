package com.banquito.core.banking.seguridadcliente.controlador;

import com.banquito.core.banking.seguridadcliente.dao.ClienteRepository;
import com.banquito.core.banking.seguridadcliente.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void createCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public void updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}
