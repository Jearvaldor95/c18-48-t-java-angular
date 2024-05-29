package com.c1848tjavaangular.domi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c1848tjavaangular.domi.dtos.ServicioProfesionDto;
import com.c1848tjavaangular.domi.models.entities.ServicioProfesion;
import com.c1848tjavaangular.domi.repository.ServicioProfesionRepository;
import com.c1848tjavaangular.domi.services.ServicioProfesionService;
@Service
public class ServicioProfesionImplService implements ServicioProfesionService{
    @Autowired
    private ServicioProfesionRepository servicioProfesionRepository;

    @Override
    public List<ServicioProfesion> listAll() {
        
        return(List)servicioProfesionRepository.findAll();
    }

    @Override
    public ServicioProfesion save(ServicioProfesionDto servicioProfesionDto) {
        
        ServicioProfesion servicioProfesion = ServicioProfesion.builder()
                                           .idServicioProfesion(servicioProfesionDto.getIdServicioProfesion())
                                           .build();
        return servicioProfesionRepository.save(servicioProfesion);
    }

    @Override
    public ServicioProfesion findById(Integer id) {
        
        return servicioProfesionRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(ServicioProfesion servicioProfesion) {
        
        servicioProfesionRepository.delete(servicioProfesion);
    }

    @Override
    public boolean existsById(Integer id) {
        
        return servicioProfesionRepository.existsById(id);
    }
    
}
