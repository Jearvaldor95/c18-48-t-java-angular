package com.c1848tjavaangular.domi.services;

import java.util.List;

import com.c1848tjavaangular.domi.dtos.ServicioProfesionDto;
import com.c1848tjavaangular.domi.models.entities.ServicioProfesion;

public interface ServicioProfesionService {
    List<ServicioProfesion> listAll();

    ServicioProfesion save(ServicioProfesionDto servicioProfesion);

    ServicioProfesion findById(Integer id);

    void delete(ServicioProfesion servicioProfesion);

    boolean existsById(Integer id);
}
