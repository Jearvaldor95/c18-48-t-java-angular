package com.c1848tjavaangular.domi.dtos;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Builder
public class UsuariosDto implements Serializable {
    private Integer idUsuarios;
    @NotNull (message="Nombre requerido!")
    private String nombre;
    @NotNull (message="Apellido requerido!")
    private String apellidos;
    @NotNull (message="username requerido!")
    private String username;
    @NotNull (message="password requerido!")
    private String password;
    @NotNull (message="telefono requerido!")
    private String telefono;
    private String foto;
    @NotNull (message="email requerido!")
    private String email;
    private Date fecha_nacimiento;
    @NotNull (message="direccion requerido!")
    private String direccion;
    private boolean isProfesional;
}
