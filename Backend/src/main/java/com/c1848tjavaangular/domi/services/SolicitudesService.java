package com.c1848tjavaangular.domi.services;

import java.util.List;

import com.c1848tjavaangular.domi.dtos.SolicitudesDto;
import com.c1848tjavaangular.domi.models.entities.Solicitudes;

public interface SolicitudesService {
    List<Solicitudes> listAll();

    Solicitudes save(SolicitudesDto usuarios);

    Solicitudes findById(Integer id);

    void delete(Solicitudes solicitudes);

    boolean existsById(Integer id);
}
