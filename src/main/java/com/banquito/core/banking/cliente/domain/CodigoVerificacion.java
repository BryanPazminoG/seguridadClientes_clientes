package com.banquito.core.banking.cliente.domain;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CodigoVerificacion {
  private String codigo;
  @Field("fecha_creacion")
  private LocalDateTime fechaCreacion;
  private String estado;
}
