package com.c1848tjavaangular.domi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c1848tjavaangular.domi.models.entities.Solicitudes;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudesRepository extends JpaRepository<Solicitudes, Integer> {
    
}
