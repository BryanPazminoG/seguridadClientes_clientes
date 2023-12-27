package com.banquito.core.banking.seguridadcliente.controlador;

import com.banquito.core.banking.seguridadcliente.domain.ClienteVista;
import com.banquito.core.banking.seguridadcliente.services.ClienteVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clienteVistas")
public class ClienteVistaController {

    @Autowired
    private ClienteVistaService clienteVistaService;

    @GetMapping
    public List<ClienteVista> getAllClienteVistas() {
        return clienteVistaService.getAllClienteVistas();
    }

    @GetMapping("/{codCliente}/{estado}")
    public List<ClienteVista> getClienteVistasByCodClienteAndEstado(@PathVariable Long codCliente, @PathVariable boolean estado) {
        return clienteVistaService.getClienteVistasByCodClienteAndEstado(codCliente, estado);
    }

    @PostMapping
    public void createClienteVista(@RequestBody ClienteVista clienteVista) {
        clienteVistaService.createClienteVista(clienteVista);
    }

    @PutMapping("/{codCliente}/{codVista}")
    public void updateClienteVista(@PathVariable Long codCliente, @PathVariable Long codVista, @RequestBody ClienteVista clienteVista) {
        clienteVistaService.updateClienteVista(codCliente, codVista, clienteVista);
    }

    @DeleteMapping("/{codCliente}/{codVista}")
    public void deleteClienteVista(@PathVariable Long codCliente, @PathVariable Long codVista) {
        clienteVistaService.deleteClienteVista(codCliente, codVista);
    }
}
