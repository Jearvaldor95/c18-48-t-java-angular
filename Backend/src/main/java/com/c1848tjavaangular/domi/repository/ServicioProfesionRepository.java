package com.c1848tjavaangular.domi.repository;

import com.c1848tjavaangular.domi.dtos.ServiciosUsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.c1848tjavaangular.domi.models.entities.ServicioProfesion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioProfesionRepository extends JpaRepository<ServicioProfesion, Integer> {

    // Todos los usuarios profesionales con sus servicios
    @Query("SELECT new com.c1848tjavaangular.domi.dtos.ServiciosUsuarioDto(sp.id, u.nombre, u.apellidos, u.telefono, u.email, u.direccion, s.nombre) \n" +
            "FROM Usuarios u \n" +
            "JOIN ServicioProfesion sp ON u.id = sp.usuario.id \n" +
            "JOIN Servicios s ON sp.servicio.id = s.id ")
    List<ServiciosUsuarioDto> findAllServiciosAndUsuarios();

    // Usuarios profesionales con sus servicios por nombre servicio
    @Query("SELECT new com.c1848tjavaangular.domi.dtos.ServiciosUsuarioDto(sp.id, u.nombre, u.apellidos, u.telefono, u.email, u.direccion, s.nombre) \n" +
            "FROM Usuarios u \n" +
            "JOIN ServicioProfesion sp ON u.id = sp.usuario.id \n" +
            "JOIN Servicios s ON sp.servicio.id = s.id  WHERE s.nombre =:nombreServicio")
    List<ServiciosUsuarioDto> findByServiciosNombre(String nombreServicio);

    // Usuarios profesionales con sus servicios por nombre servicio y direccion
    @Query("SELECT new com.c1848tjavaangular.domi.dtos.ServiciosUsuarioDto(sp.id, u.nombre, u.apellidos, u.telefono, u.email, u.direccion, s.nombre) \n" +
            "FROM Usuarios u \n" +
            "JOIN ServicioProfesion sp ON u.id = sp.usuario.id \n" +
            "JOIN Servicios s ON sp.servicio.id = s.id  WHERE s.nombre =:nombreServicio AND u.direccion =:direccionUsuario")
    List<ServiciosUsuarioDto> findByServiciosNombreAndUsuariosDireccion(String nombreServicio, String direccionUsuario);

    // Usuarios profesionales con sus servicios por direccion
    @Query("SELECT new com.c1848tjavaangular.domi.dtos.ServiciosUsuarioDto(sp.id, u.nombre, u.apellidos, u.telefono, u.email, u.direccion, s.nombre) \n" +
            "FROM Usuarios u \n" +
            "JOIN ServicioProfesion sp ON u.id = sp.usuario.id \n" +
            "JOIN Servicios s ON sp.servicio.id = s.id  WHERE u.direccion =:direccionUsuario")
    List<ServiciosUsuarioDto> findByUsuariosDireccion(String direccionUsuario);
}
