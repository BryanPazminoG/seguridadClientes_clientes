package com.banquito.core.banking.seguridadcliente.dao;

import com.banquito.core.banking.seguridadcliente.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Cliente findByUsuario(String usuario);

    // Método personalizado para la seguridad del cliente
    Cliente findByUsuarioAndContrasena(String usuario, String contrasena);
}
