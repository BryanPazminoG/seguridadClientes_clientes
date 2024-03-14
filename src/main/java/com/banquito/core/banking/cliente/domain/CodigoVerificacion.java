package com.banquito.core.banking.cliente.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CodigoVerificacion {
  private String codigo;
  private LocalDateTime fechaCreacion;
  private String estado;
}
