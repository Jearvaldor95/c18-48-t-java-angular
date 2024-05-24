package com.c1848tjavaangular.domi.models.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Servicios implements Serializable{
    private Integer idServicio;
    private String nombre;
}
