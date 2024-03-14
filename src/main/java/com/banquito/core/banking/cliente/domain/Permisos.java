package com.banquito.core.banking.cliente.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Permisos {
  private List<String> cuentas;
  private List<String> creditos;
  private List<String> tarjetas;
}
