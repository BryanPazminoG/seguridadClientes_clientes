package com.banquito.core.banking.cliente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.banking.cliente.domain.Cliente;
import com.banquito.core.banking.cliente.dto.ClienteDTO;
import com.banquito.core.banking.cliente.service.ClienteService;

import lombok.extern.log4j.Log4j2;



@Log4j2
@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://34.86.49.111:4200", "http://34.145.220.97:4204", "http://34.145.219.32:4200", "http://34.162.115.216:4200"})
//@CrossOrigin(origins = "", allowedHeaders = "", methods = {RequestMethod.GET, RequestMethod.POST})
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
        log.info("Se va a crear el cliente: {}", cliente.getNombreUsuario());
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
            log.info("Se va a actualizar la contrasena de cliente: {}", cliente.getNombreUsuario());
            clienteService.actualizarContrasena(cliente);
            log.info("Contrasena actualizada correctamente");
            return ResponseEntity.ok().build();
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/sesion")
    public ResponseEntity<Cliente> iniciar (@RequestBody ClienteDTO clienteDTO) {
        log.info("Se va a iniciar sesion: {}", clienteDTO.getNombreUsuario());
        Cliente cliente = this.clienteService.validarCredenciales(clienteDTO.getNombreUsuario(),clienteDTO.getClave());
        try {
            if (cliente != null) {
                log.info("Usuario y contrasena correctos");
                return ResponseEntity.ok(cliente);
            }else{
                return ResponseEntity.badRequest().build();
            }
            
        } catch (RuntimeException rte) {
            log.error("Error al iniciar sesion", rte);
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping
    public ResponseEntity<Void> actualizarCodigoVerificacion(@RequestParam("codCliente") String codCliente) {
        try {
            log.info("Se va a actualizar el codigo de verificacion del cliente: {}", codCliente);
            clienteService.actualizarCodigoVerificacion(codCliente);
            log.info("Codigo de verificacion actualizado correctamente");
            return ResponseEntity.ok().build();
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }

}
