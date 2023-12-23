package com.banquito.core.banking.seguridadcliente.services;

import com.banquito.core.banking.seguridadcliente.dao.ClienteRepository;
import com.banquito.core.banking.seguridadcliente.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente) {
        // Verificar si el usuario ya existe
        Cliente existingCliente = (Cliente) clienteRepository.findByUsuario(cliente.getUsuario());
        if (existingCliente != null) {
            throw new IllegalArgumentException("El usuario ya existe");
        }
        Instant now = Instant.now();
        cliente.setFechaCreacion(now);
        cliente.setFechaUltimoCambio(now);
        cliente.setActivo(true);  // Nuevo cliente se establece como activo

        // Puedes agregar más validaciones y lógica aquí antes de guardar el cliente

        // Guardar el cliente
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorCodigo(Integer codigoCliente) {
        return clienteRepository.findById(codigoCliente);
    }

    public List<Cliente> obtenerClientesPorUsuario(String usuario) {
        return clienteRepository.findByUsuario(usuario);
    }

    public void actualizarCliente(Integer codigoCliente, Cliente clienteActualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(codigoCliente);

        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();

            // Actualizar los campos necesarios del cliente
            cliente.setUsuario(clienteActualizado.getUsuario());
            cliente.setContraseña(clienteActualizado.getContraseña());
            // Actualiza otros campos según sea necesario

            // Configurar la fecha de último cambio al actualizar
            cliente.setFechaUltimoCambio(Instant.now());

            // Puedes agregar más validaciones y lógica aquí antes de actualizar el cliente

            // Actualizar el cliente
            clienteRepository.save(cliente);
        } else {
            throw new IllegalArgumentException("Cliente no encontrado");
        }
    }

    public void eliminarCliente(Integer codigoCliente) {
        // Resto del código para eliminar/desactivar el cliente...
    }
}
