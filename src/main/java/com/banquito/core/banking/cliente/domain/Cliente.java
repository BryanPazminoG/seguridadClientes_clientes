package com.banquito.core.banking.cliente.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@TypeAlias("Cliente")
@NoArgsConstructor
@Document(collection = "SEG_CLIENTE")
public class Cliente {
    @Id
    private String id;
    
    @Indexed(unique = true)
    @Field  ("cod_cliente")
    private String codCliente;
    
    @Field  ("nombre_usuario")
    private String nombreUsuario;

    @Field  ("clave")
    private String clave;

    @Field ("estado")
    private String estado;

    @Field  ("fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Field  ("fecha_ultima_modificacion")
    private LocalDateTime fechaUltimaModificacion;

    @Field  ("fecha_ultimo_acceso")
    private LocalDateTime fechaUltimoAcceso;

    @Field ("tipo_cliente")
    private String tipoCliente;

    @Field ("codigo_verificacion")
    private CodigoVerificacion codigoVerificacion;

    @Field("permisos")
    private Permisos permisos;

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
        return "Cliente [id=" + id + ", codCliente=" + codCliente + ", nombreUsuario=" + nombreUsuario + ", clave="
                + clave + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion + ", fechaUltimaModificacion="
                + fechaUltimaModificacion + ", fechaUltimoAcceso=" + fechaUltimoAcceso + ", tipoCliente=" + tipoCliente
                + ", codigoVerificacion=" + codigoVerificacion + ", permisos=" + permisos + ", version=" + version
                + "]";
    }

}
