package com.banquito.core.banking.seguridadcliente.dao;

import com.banquito.core.banking.seguridadcliente.domain.Vista;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VistaRepository extends CrudRepository<Vista, Long> {
    List<Vista> findByNombreVista(String nombreVista);
}
