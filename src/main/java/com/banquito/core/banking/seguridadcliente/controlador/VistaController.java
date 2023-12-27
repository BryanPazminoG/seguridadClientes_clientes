package com.banquito.core.banking.seguridadcliente.controlador;

import com.banquito.core.banking.seguridadcliente.dao.VistaRepository;
import com.banquito.core.banking.seguridadcliente.domain.Vista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/vistas")
    public class VistaController {

        @Autowired
        private VistaRepository vistaRepository;

        @GetMapping
        public List<Vista> getAllVistas() {
            return (List<Vista>) vistaRepository.findAll();
        }

        @GetMapping("/{id}")
        public Vista getVistaById(@PathVariable Long id) {
            return vistaRepository.findById(id).orElse(null);
        }

        @PostMapping
        public void createVista(@RequestBody Vista vista) {
            vistaRepository.save(vista);
        }

        @PutMapping("/{id}")
        public void updateVista(@PathVariable Long id, @RequestBody Vista vista) {
            vistaRepository.save(vista);
        }

        @DeleteMapping("/{id}")
        public void deleteVista(@PathVariable Long id) {
            vistaRepository.deleteById(id);
        }

}

