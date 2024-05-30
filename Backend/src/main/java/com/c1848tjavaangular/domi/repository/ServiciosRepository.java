package com.c1848tjavaangular.domi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c1848tjavaangular.domi.models.entities.Servicios;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Integer> {
    
}
