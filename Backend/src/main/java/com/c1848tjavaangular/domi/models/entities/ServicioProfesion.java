package com.c1848tjavaangular.domi.models.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "servicio_profesion")
@Entity

public class ServicioProfesion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservicio_profesion")
    private Integer idServicioProfesion;

    @ManyToOne
     @JoinColumn(name = "idservicio")
     private Servicios servicio;
    @ManyToOne
     @JoinColumn(name = "idusuario")
     private Usuarios usuario;

}
