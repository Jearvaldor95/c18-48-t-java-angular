package com.c1848tjavaangular.domi.services;

import java.util.List;

import com.c1848tjavaangular.domi.dtos.ServiciosDto;
import com.c1848tjavaangular.domi.models.entities.Servicios;

public interface ServiciosService {
    List<Servicios> listAll();

    Servicios save(ServiciosDto servicios);

    Servicios findById(Integer id);

    void delete(Servicios servicios);

    boolean existsById(Integer id);
}
