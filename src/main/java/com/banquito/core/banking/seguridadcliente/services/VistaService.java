package com.banquito.core.banking.seguridadcliente.services;

import com.banquito.core.banking.seguridadcliente.dao.VistaRepository;
import com.banquito.core.banking.seguridadcliente.domain.Vista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VistaService {
    @Autowired
    private VistaRepository vistaRepository;

    public List<Vista> getAllVistas() {
        return (List<Vista>) vistaRepository.findAll();
    }

    public Vista getVistaById(Long id) {
        return vistaRepository.findById(id).orElse(null);
    }

    public void createVista(Vista vista) {
        vistaRepository.save(vista);
    }

    public void updateVista(Vista vista) {
        vistaRepository.save(vista);
    }

    public void deleteVista(Long id) {
        vistaRepository.deleteById(id);
    }
}
