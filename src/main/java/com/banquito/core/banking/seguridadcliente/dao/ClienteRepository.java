package com.banquito.core.banking.seguridadcliente.dao;

import com.banquito.core.banking.seguridadcliente.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    Cliente findByUsuario(String usuario);
    Cliente findByCodCliente(Integer codCliente);

}
