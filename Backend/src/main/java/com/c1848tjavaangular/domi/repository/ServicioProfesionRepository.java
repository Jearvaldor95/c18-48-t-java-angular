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
    @Query("SELECT new com.c1848tjavaangular.domi.dtos.ServiciosUsuarioDto(sp.id, u.nombre, u.apellidos, u.sobreMi, u.foto, u.telefono, u.email, u.direccion, s.nombre) \n" +
            "FROM Usuarios u \n" +
            "JOIN ServicioProfesion sp ON u.id = sp.usuario.id \n" +
            "JOIN Servicios s ON sp.servicio.id = s.id ")
    List<ServiciosUsuarioDto> findAllServiciosAndUsuarios();

    // Usuarios profesionales con sus servicios por nombre servicio
    @Query("SELECT new com.c1848tjavaangular.domi.dtos.ServiciosUsuarioDto(sp.id, u.nombre, u.apellidos, u.sobreMi, u.foto, u.telefono, u.email, u.direccion, s.nombre) \n" +
            "FROM Usuarios u \n" +
            "JOIN ServicioProfesion sp ON u.id = sp.usuario.id \n" +
            "JOIN Servicios s ON sp.servicio.id = s.id  WHERE s.nombre LIKE %:nombreServicio%")
    List<ServiciosUsuarioDto> findByServiciosNombre(String nombreServicio);

    // Usuarios profesionales con sus servicios por nombre servicio y direccion
    @Query("SELECT new com.c1848tjavaangular.domi.dtos.ServiciosUsuarioDto(sp.id, u.nombre, u.apellidos, u.sobreMi, u.foto, u.telefono, u.email, u.direccion, s.nombre) \n" +
            "FROM Usuarios u \n" +
            "JOIN ServicioProfesion sp ON u.id = sp.usuario.id \n" +
            "JOIN Servicios s ON sp.servicio.id = s.id  WHERE s.nombre LIKE %:nombreServicio% AND u.direccion LIKE %:direccionUsuario%")
    List<ServiciosUsuarioDto> findByServiciosNombreAndUsuariosDireccion(String nombreServicio, String direccionUsuario);

    // Usuarios profesionales con sus servicios por direccion
    @Query("SELECT new com.c1848tjavaangular.domi.dtos.ServiciosUsuarioDto(sp.id, u.nombre, u.apellidos, u.sobreMi, u.foto, u.telefono, u.email, u.direccion, s.nombre) \n" +
            "FROM Usuarios u \n" +
            "JOIN ServicioProfesion sp ON u.id = sp.usuario.id \n" +
            "JOIN Servicios s ON sp.servicio.id = s.id  WHERE u.direccion LIKE %:direccionUsuario%")
    List<ServiciosUsuarioDto> findByUsuariosDireccion(String direccionUsuario);

    // Obtener el email del usuario profesional por el idservicio_profesion
    @Query(value = "SELECT  us.email\n" +
            "FROM servicio_profesion sp \n" +
            "JOIN usuarios us ON sp.idusuario = us.idusuario\n" +
            "WHERE sp.idservicio_profesion =:idServicioP", nativeQuery = true)
    String emailByIdServicioProfesional(Integer idServicioP);

    // Obtener el username del usuario profesional por el idservicio_profesion
    @Query(value = "SELECT  us.username\n" +
            "FROM servicio_profesion sp \n" +
            "JOIN usuarios us ON sp.idusuario = us.idusuario\n" +
            "WHERE sp.idservicio_profesion =:idServicioP", nativeQuery = true)
    String usernameByIdServicioProfesional(Integer idServicioP);

}
