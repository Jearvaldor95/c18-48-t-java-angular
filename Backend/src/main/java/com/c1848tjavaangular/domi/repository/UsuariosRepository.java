package com.c1848tjavaangular.domi.repository;

import org.springframework.data.repository.CrudRepository;

import com.c1848tjavaangular.domi.models.entities.Usuarios;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsuariosRepository extends CrudRepository <Usuarios,Integer>{

    Optional<Usuarios> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
}
