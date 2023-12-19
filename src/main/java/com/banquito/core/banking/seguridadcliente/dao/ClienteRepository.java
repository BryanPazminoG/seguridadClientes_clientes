package com.banquito.core.banking.seguridadcliente.dao;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Cliente>{
    List<Cliente> findByCodigoCliente(String COD_CLIENTE);
}
