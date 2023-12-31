package com.banquito.core.banking.seguridadcliente.services;

import com.banquito.core.banking.seguridadcliente.dao.VistaRepository;
import org.springframework.stereotype.Service;

@Service
public class VistaService {

    private VistaRepository vistaRepository;

    public VistaService(VistaRepository vistaRepository) {
        this.vistaRepository = vistaRepository;
    }


}
