package com.c1848tjavaangular.domi.services;

import java.util.List;

import com.c1848tjavaangular.domi.dtos.UsuariosDto;
import com.c1848tjavaangular.domi.models.entities.Usuarios;

public interface UsuariosService {

    List<Usuarios> listAll();

    Usuarios save(UsuariosDto usuarios);

    Usuarios findById(Integer id);

    void delete(Usuarios usuarios);

    boolean existsById(Integer id);


}
