package com.banquito.core.banking.cliente.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.core.banking.cliente.domain.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Cliente findByNombreUsuarioAndClave(String nombreUsuario, String clave);
    Cliente findByNombreUsuario(String nombreUsuario);
    Optional<Cliente> findByCodCliente(String codCliente);
}
