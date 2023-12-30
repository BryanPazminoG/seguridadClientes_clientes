package com.banquito.core.banking.seguridadcliente.dao;

import com.banquito.core.banking.seguridadcliente.domain.ClienteVista;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteVistaRepository extends CrudRepository<ClienteVista, Integer> {
    List<ClienteVista> findByCodClienteAndEstado(Integer codCliente, String estado);

}
