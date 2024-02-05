package com.banquito.core.banking.cliente.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.core.banking.cliente.domain.Cliente;

public interface ClienteRepository extends MongoRepository <Cliente, String> {
    Cliente findByUsuarioAndContrasena(String usuario, String contrasena);
    Cliente findByUsuario(String Usuario);

}
