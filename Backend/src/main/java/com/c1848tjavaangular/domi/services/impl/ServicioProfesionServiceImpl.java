package com.c1848tjavaangular.domi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.c1848tjavaangular.domi.dtos.ServiciosUsuarioDto;
import com.c1848tjavaangular.domi.exceptions.AppNotFoundException;
import com.c1848tjavaangular.domi.mappers.ServicioProfesionMapper;
import com.c1848tjavaangular.domi.models.entities.Usuarios;
import com.c1848tjavaangular.domi.repository.UsuariosRepository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.c1848tjavaangular.domi.dtos.ServicioProfesionDto;
import com.c1848tjavaangular.domi.models.entities.ServicioProfesion;
import com.c1848tjavaangular.domi.repository.ServicioProfesionRepository;
import com.c1848tjavaangular.domi.services.ServicioProfesionService;
@Service
public class ServicioProfesionServiceImpl implements ServicioProfesionService{
    private final ServicioProfesionRepository servicioProfesionRepository;
    private final ServicioProfesionMapper servicioProfesionMapper;
    private final UsuariosRepository usuariosRepository;

    public ServicioProfesionServiceImpl(ServicioProfesionRepository servicioProfesionRepository, ServicioProfesionMapper servicioProfesionMapper, UsuariosRepository usuariosRepository){
        this.servicioProfesionRepository = servicioProfesionRepository;
        this.servicioProfesionMapper = servicioProfesionMapper;
        this.usuariosRepository = usuariosRepository;
    }


    @Override
    public List<ServiciosUsuarioDto> findAllServiciosAndUsuarios() {
        return servicioProfesionRepository.findAllServiciosAndUsuarios();
    }

    @Override
    public ServicioProfesionDto save(Integer idUsuario,ServicioProfesionDto servicioProfesionDto) {
        Usuarios usuario = usuariosRepository.findById(idUsuario)
                .orElseThrow(()-> new AppNotFoundException("Usuario not found!"));
        ServicioProfesion servicioProfesion = servicioProfesionMapper.toServicioProfesion(servicioProfesionDto);
        servicioProfesion.setIdUsuario(usuario.getIdUsuarios());
        return servicioProfesionMapper.toServicioProfesionDto(servicioProfesionRepository.save(servicioProfesion));
    }

    @Override
    public ServicioProfesionDto findById(Integer id) {
        ServicioProfesion servicioProfesion = servicioProfesionRepository.findById(id)
                .orElseThrow(()-> new AppNotFoundException("Servicio not found"));
        return servicioProfesionMapper.toServicioProfesionDto(servicioProfesion);
    }

    @Override
    public List<ServiciosUsuarioDto> findByServiciosNombre(String nombreServicio) {
        return servicioProfesionRepository.findByServiciosNombre(nombreServicio);
    }

    @Override
    public List<ServiciosUsuarioDto> findByServiciosNombreAndUsuariosDireccion(String nombre, String direccion) {
        return servicioProfesionRepository.findByServiciosNombreAndUsuariosDireccion(nombre, direccion);
    }

    @Override
    public List<ServiciosUsuarioDto> findByUsuariosDireccion(String direccion) {
        return servicioProfesionRepository.findByUsuariosDireccion(direccion);
    }

    @Override
    public ServicioProfesionDto delete(Integer id) {
        ServicioProfesion servicioProfesion = servicioProfesionRepository.findById(id)
                .orElseThrow(()-> new AppNotFoundException("Servicio not found!"));
        ServicioProfesionDto servicioProfesionDto = servicioProfesionMapper.toServicioProfesionDto(servicioProfesion);
        servicioProfesionRepository.deleteById(id);
        return servicioProfesionDto;
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public String getEmailUsuario(Integer idServicioP) {
        return servicioProfesionRepository.emailByIdServicioProfesional(idServicioP);
    }

    @Override
    public String getUsername(Integer idServicioP) {
        return servicioProfesionRepository.usernameByIdServicioProfesional(idServicioP);
    }
}
