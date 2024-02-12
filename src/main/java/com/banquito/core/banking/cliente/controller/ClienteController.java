package com.banquito.core.banking.cliente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.banking.cliente.domain.Cliente;
import com.banquito.core.banking.cliente.dto.ClienteDTO;
import com.banquito.core.banking.cliente.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/seguridad-cliente")

public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodas() {
        log.info("Obteniendo listado de todos los clientes");
        return ResponseEntity.ok(clienteService.listarTodo());
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody ClienteDTO cliente) {
        log.info("Se va a crear el cliente: {}", cliente.getUsuario());
        try {
            this.clienteService.crear(cliente);
            log.info("Se creo exitosamente el usuario");
            return ResponseEntity.noContent().build();
        } catch (RuntimeException rte) {
            log.error("Error al crear el cliente", rte);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Void> actualizarContrasena(@RequestBody ClienteDTO cliente) {
        try {
            log.info("Se va a actualizar la contrasena de cliente: {}", cliente.getUsuario());
            clienteService.actualizarContrasena(cliente);
            log.info("Contrasena actualizada correctamente");
            return ResponseEntity.ok().build();
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/sesion")
    public ResponseEntity<Boolean> iniciar (@RequestBody ClienteDTO clienteDTO) {
        log.info("Se va a iniciar sesion: {}", clienteDTO.getUsuario());
        try {
            if (this.clienteService.validarCredenciales(clienteDTO.getUsuario(),clienteDTO.getContrasena())) {
                log.info("Usuario y contrasena correctos");
                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.badRequest().build();
            }
            
        } catch (RuntimeException rte) {
            log.error("Error al iniciar sesion", rte);
            return ResponseEntity.badRequest().build();
        }
    }

}
