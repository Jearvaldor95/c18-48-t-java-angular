package com.c1848tjavaangular.domi.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosDto {
    private Integer idUsuarios;
    private String nombre;
    private String apellidos;
    private String username;
    private String email;
    private String telefono;
    private String foto;
    private LocalDate fecha_nacimiento;
    private String direccion;
    private Boolean isProfesional;

}
