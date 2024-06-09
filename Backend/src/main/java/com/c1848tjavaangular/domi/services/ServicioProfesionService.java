package com.c1848tjavaangular.domi.services;

import java.util.List;

import com.c1848tjavaangular.domi.dtos.ServicioProfesionDto;
import com.c1848tjavaangular.domi.dtos.ServiciosUsuarioDto;


public interface ServicioProfesionService {
    // Todos los usuarios profesionales con sus servicios
    List<ServiciosUsuarioDto> findAllServiciosAndUsuarios();

    ServicioProfesionDto save(Integer idUsuario,ServicioProfesionDto servicioProfesionDto);

    ServicioProfesionDto findById(Integer id);

    // Usuarios profesionales con sus servicios por nombre servicio
    List<ServiciosUsuarioDto> findByServiciosNombre(String nombre);

    // Usuarios profesionales con sus servicios por nombre servicio y direccion
    List<ServiciosUsuarioDto> findByServiciosNombreAndUsuariosDireccion(String nombre, String direccion);

    // Usuarios profesionales con sus servicios por direccion
    List<ServiciosUsuarioDto> findByUsuariosDireccion(String direccion);

    ServicioProfesionDto delete(Integer id);

    String getEmailUsuario(Integer idServicioP);

    String getUsername(Integer idServicioP);
}
