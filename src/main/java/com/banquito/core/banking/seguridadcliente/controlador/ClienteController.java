package com.banquito.core.banking.seguridadcliente.controlador;

import com.banquito.core.banking.seguridadcliente.domain.Cliente;
import com.banquito.core.banking.seguridadcliente.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente crearCliente(@RequestBody @Valid Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @GetMapping
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteService.obtenerTodosLosClientes();
    }

    @GetMapping("/{codigoCliente}")
    public Optional<Cliente> obtenerClientePorCodigo(@PathVariable Integer codigoCliente) {
        return clienteService.obtenerClientePorCodigo(codigoCliente);
    }

    @GetMapping("/usuario/{usuario}")
    public List<Cliente> obtenerClientesPorUsuario(@PathVariable String usuario) {
        return clienteService.obtenerClientesPorUsuario(usuario);
    }

    @PutMapping("/{codigoCliente}")
    public void actualizarCliente(@PathVariable Integer codigoCliente, @RequestBody @Valid Cliente cliente) {
        clienteService.actualizarCliente(codigoCliente, cliente);
    }

    @DeleteMapping("/{codigoCliente}")
    public void eliminarCliente(@PathVariable Integer codigoCliente) {
        clienteService.eliminarCliente(codigoCliente);
    }
}
