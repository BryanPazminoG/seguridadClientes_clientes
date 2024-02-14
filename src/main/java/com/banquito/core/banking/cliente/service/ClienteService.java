package com.banquito.core.banking.cliente.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.codec.digest.DigestUtils;

import com.banquito.core.banking.cliente.dao.ClienteRepository;
import com.banquito.core.banking.cliente.domain.Cliente;
import com.banquito.core.banking.cliente.dto.ClienteBuilder;
import com.banquito.core.banking.cliente.dto.ClienteDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteService {
    public final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodo() {
        log.info("Obteniendo listado de todos los clientes");
        return clienteRepository.findAll();
    }

    public void crear(ClienteDTO dto) {
        try {
            Cliente cliente = ClienteBuilder.toCliente(dto);
            cliente.setCodCliente(dto.getCodCliente());
            cliente.setContrasena(new DigestUtils("MD5").digestAsHex(dto.getContrasena()));
            cliente.setFechaUltimaModificacion(LocalDateTime.now());
            cliente.setFechaCreacion(LocalDateTime.now());
            this.clienteRepository.save(cliente);
            log.info("Se creo el cliente: {}", cliente);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el cliente.", e);
        }
    }

    public void actualizar(ClienteDTO dto) {
        try {
            log.info("Se va a buscar el cliente", dto.getUsuario());
            Optional<Cliente> clienteOpt = this.clienteRepository.findById(dto.getCodCliente());

            if (clienteOpt.isPresent()) {
                log.info("Cliente encontrado.");
                Cliente cliente = new Cliente();
                cliente = clienteOpt.get();
                log.info("Se va a actualizar el cliente: ", cliente);
                this.clienteRepository.save(cliente);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el cliente");

        }
    }

    @Transactional
    public Boolean actualizarContrasena(ClienteDTO dto) {
        try {
            log.info("Se va a buscar el cliente: {}", dto.getUsuario());
            Cliente clienteAux = this.clienteRepository.findByUsuario(dto.getUsuario());
            if (clienteAux != null) {
                log.info("Cliente encontrado");
                dto.setContrasena(new DigestUtils("MD5").digestAsHex(dto.getContrasena()));
                log.info("Contrasena encriptada");
                Cliente clienteTmp = ClienteBuilder.toCliente(dto);
                Cliente cliente = ClienteBuilder.copyCliente(clienteTmp, clienteAux);
                cliente.setFechaUltimaModificacion(LocalDateTime.now());
                log.info("Guardando informacion");
                this.clienteRepository.save(cliente);
                log.info("Se actualizo la contrasena del usuario: {}", cliente.getUsuario());
                return true;
            }
            else{
                log.error("Usuario no encontrado");
                return false;
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la contrasena.", e);
        }
    }

    public Cliente validarCredenciales(String usuario, String contrasena) {
        try {
            log.info("Validando credenciales de usuario : {}",usuario);
            String contrasenaHash = new DigestUtils("MD5").digestAsHex(contrasena);
            log.info("Contrasena cifrada");
            Cliente cliente = this.clienteRepository.findByUsuarioAndContrasena(usuario, contrasenaHash);
            if (cliente != null) {
                return cliente;
            } else {
                throw new RuntimeException("Credenciales incorrectas");
            }
        } catch (Exception e) {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }

}
