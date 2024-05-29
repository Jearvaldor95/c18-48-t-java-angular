package com.c1848tjavaangular.domi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c1848tjavaangular.domi.dtos.ServiciosDto;
import com.c1848tjavaangular.domi.models.entities.Servicios;
import com.c1848tjavaangular.domi.repository.ServiciosRepository;
import com.c1848tjavaangular.domi.services.ServiciosService;

import jakarta.transaction.Transactional;
@Service
public class ServiciosImplService implements ServiciosService{
    @Autowired
    private ServiciosRepository serviciosRepository;

    @Override
    public List<Servicios> listAll() {
        
        return(List)serviciosRepository.findAll();
    }

    @Transactional
    @Override
    public Servicios save(ServiciosDto serviciosDto) {
        
        Servicios servicio = Servicios.builder()
                          .idServicio(serviciosDto.getIdServicio())
                          .nombre(serviciosDto.getNombre())
                          .build();
        return serviciosRepository.save(servicio);  
                          
    }

    @Transactional
    @Override
    public Servicios findById(Integer id) {
        
        return serviciosRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Servicios servicios) {
        
        serviciosRepository.delete(servicios);
    }

    @Override
    public boolean existsById(Integer id) {
        
        return serviciosRepository.existsById(id);
    }
    
}
