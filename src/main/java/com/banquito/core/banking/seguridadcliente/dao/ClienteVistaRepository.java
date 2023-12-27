package com.banquito.core.banking.seguridadcliente.dao;

import com.banquito.core.banking.seguridadcliente.domain.ClienteVista;
import com.banquito.core.banking.seguridadcliente.domain.ClienteVistaPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteVistaRepository extends CrudRepository<ClienteVista, Long> {
    List<ClienteVista> findByCodClienteAndEstado(Long codCliente, boolean estado);

    void deleteById(ClienteVistaPK clienteVistaPK);
}
