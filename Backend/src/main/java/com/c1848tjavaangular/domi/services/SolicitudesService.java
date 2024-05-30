package com.c1848tjavaangular.domi.services;

import java.util.List;

import com.c1848tjavaangular.domi.dtos.SolicitudesDto;
import com.c1848tjavaangular.domi.models.entities.Solicitudes;

public interface SolicitudesService {
    List<SolicitudesDto> findAll();

    SolicitudesDto save(Integer idUsuario, SolicitudesDto solicitudesDto);

    SolicitudesDto findById(Integer id);

    SolicitudesDto update(Integer idSolicitud, SolicitudesDto solicitudesDto);

    SolicitudesDto findByIdUsuario(Integer idUsuario);

    SolicitudesDto delete(Integer idSolicitud);

    boolean existsById(Integer id);
}
