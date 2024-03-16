package com.banquito.core.banking.cliente;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.banquito.core.banking.cliente.controller.ClienteController;
import com.banquito.core.banking.cliente.dao.ClienteRepository;
import com.banquito.core.banking.cliente.domain.Cliente;
import com.banquito.core.banking.cliente.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@ExtendWith(MockitoExtension.class)

public class ClienteControllerTest {

    private MockMvc mockMvcTipoCliente;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectwrittWriter = objectMapper.writer();

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteController clienteController;

    Cliente REGISTRO_1 = new Cliente();

    @BeforeEach

    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ClienteService clienteService= new ClienteService(clienteRepository);
        clienteController = new ClienteController(clienteService);
        this.mockMvcTipoCliente = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    public void obtenerCliente_success() throws Exception {
        mockMvcTipoCliente.perform(MockMvcRequestBuilders
                .get("/api/v1/seguridad-cliente")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
