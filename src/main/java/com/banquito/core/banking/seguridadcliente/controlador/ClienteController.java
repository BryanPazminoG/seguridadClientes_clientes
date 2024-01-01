package com.banquito.core.banking.seguridadcliente.controlador;

import com.banquito.core.banking.seguridadcliente.domain.Cliente;
import com.banquito.core.banking.seguridadcliente.services.ClienteService;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/seg-cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/autenticar")
    public Cliente autenticarCliente(@RequestBody Cliente usuarioContrasena) {
        String usuario = usuarioContrasena.getUsuario();
        String contrasena = usuarioContrasena.getContrasena();
        return clienteService.auntenticar(usuario, contrasena);
    }

    @PostMapping("/crear")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente nuevoCliente) {
        Cliente clienteCreado = clienteService.crearCliente(nuevoCliente);

        if (clienteCreado != null) {
            return new ResponseEntity<>(clienteCreado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/clientes/{codCliente}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Integer codCliente) {
        Optional<Cliente> clienteEncontrado = clienteService.bucarPorId(codCliente);

        if (clienteEncontrado.isPresent()) {
            return new ResponseEntity<>(clienteEncontrado.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar-mfa/{idCliente}/{nuevoValorMFA}")
    public ResponseEntity<String> actualizarMFA(@PathVariable Integer idCliente, @PathVariable String nuevoValorMFA) {
        clienteService.actualizarAtributosCliente(idCliente, nuevoValorMFA);
        return new ResponseEntity<>("MFA actualizado correctamente", HttpStatus.OK);
    }


}
