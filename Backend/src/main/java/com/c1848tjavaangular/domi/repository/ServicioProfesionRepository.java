package com.c1848tjavaangular.domi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c1848tjavaangular.domi.models.entities.ServicioProfesion;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioProfesionRepository extends JpaRepository<ServicioProfesion, Integer> {
    
}
