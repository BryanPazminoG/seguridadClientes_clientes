package com.banquito.core.banking.cliente.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@Document(collection = "Clientes")
public class Cliente {
    @Id 
    private String codCliente;

    @Field  ("usuario")
    private String usuario;

    @Field  ("contrasena")
    private String contrasena;

    @Field  ("fecha_creacion")
    private Date fechaCreacion;

    @Field  ("fecha_ultimo_cambio")
    private Date fechaUltimaModificacion;

    @Version
    private Long version;

    public Cliente(String codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codCliente == null) ? 0 : codCliente.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (codCliente == null) {
            if (other.codCliente != null)
                return false;
        } else if (!codCliente.equals(other.codCliente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [codCliente=" + codCliente + ", usuario=" + usuario + ", contrasena=" + contrasena
                + ", fechaCreacion=" + fechaCreacion + ", fechaUltimaModificacion=" + fechaUltimaModificacion
                + ", version=" + version + "]";
    }



    
}
