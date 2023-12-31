package com.banquito.core.banking.seguridadcliente.controlador;

import com.banquito.core.banking.seguridadcliente.domain.Cliente;
import com.banquito.core.banking.seguridadcliente.services.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private  ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @PostMapping("/autenticar")
    public Cliente autenticarCliente(@RequestParam String usuario, @RequestParam String contrasenia) {
        return clienteService.autentificacionCliente(usuario, contrasenia);
    }

    @PutMapping("/actualizar-mfa/{codCliente}")
    public void actualizarMFA(@PathVariable Integer codCliente, @RequestParam String nuevoMFA) {
        clienteService.crearMFA(codCliente, nuevoMFA);
    }


}
