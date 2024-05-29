package com.c1848tjavaangular.domi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c1848tjavaangular.domi.dtos.UsuariosDto;
import com.c1848tjavaangular.domi.models.entities.Usuarios;
import com.c1848tjavaangular.domi.repository.UsuariosRepository;
import com.c1848tjavaangular.domi.services.UsuariosService;

import jakarta.transaction.Transactional;
@Service
public class UsuariosImplService implements UsuariosService{
    @Autowired
    private UsuariosRepository usuariosRepository;

    
    @Override
    public List<Usuarios> listAll(){
        return (List)usuariosRepository.findAll();
    }

    @Transactional
    @Override
    public Usuarios save(UsuariosDto usuariosDto) {
        Usuarios usuario = Usuarios.builder()
                .idUsuarios(usuariosDto.getIdUsuarios())
                .nombre(usuariosDto.getNombre())
                .apellidos(usuariosDto.getApellidos())
                .username(usuariosDto.getUsername())
                .password(usuariosDto.getPassword())
                .telefono(usuariosDto.getTelefono())
                .email(usuariosDto.getEmail())
                .direccion(usuariosDto.getDireccion())
                .isProfesional(usuariosDto.isProfesional())
                .build();

                return usuariosRepository.save(usuario);
    }

    @Transactional
    @Override
    public Usuarios findById(Integer id) {
        
        return usuariosRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Usuarios usuarios) {
        
        usuariosRepository.delete(usuarios);
    }

    @Override
    public boolean existsById(Integer id) {
        
        return usuariosRepository.existsById(id);
    }
    
}
