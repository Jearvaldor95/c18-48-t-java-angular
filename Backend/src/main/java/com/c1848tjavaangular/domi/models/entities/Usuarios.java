package com.c1848tjavaangular.domi.models.entities;

import java.io.Serializable;
import java.util.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="usuarios")
@Builder
@Entity
public class Usuarios implements Serializable {
    @Id
    @Column(name="idusuario", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuarios;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellidos;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String telefono;
    private String foto;
    @Column(nullable = false, unique = true)
    private String email;
    private Date fecha_nacimiento;
    private String direccion;
    @Column(nullable = false)
    private boolean isProfesional;
    
    
}
