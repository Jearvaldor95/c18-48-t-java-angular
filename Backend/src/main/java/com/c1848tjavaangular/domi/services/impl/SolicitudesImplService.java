package com.c1848tjavaangular.domi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c1848tjavaangular.domi.dtos.SolicitudesDto;
import com.c1848tjavaangular.domi.models.entities.Solicitudes;
import com.c1848tjavaangular.domi.repository.SolicitudesRepository;
import com.c1848tjavaangular.domi.services.SolicitudesService;

import jakarta.transaction.Transactional;
@Service
public class SolicitudesImplService implements SolicitudesService {
    
    @Autowired
    private SolicitudesRepository solicitudesRepository;

    
    @Override
    public List<Solicitudes> listAll() {
        
        return(List) solicitudesRepository.findAll();
    }

    @Transactional
    @Override
    public Solicitudes save(SolicitudesDto solicitudesDto) {
        
        Solicitudes solicitudes = Solicitudes.builder()
                               .idSolicitud(solicitudesDto.getIdSolicitud())                             
                               .mensaje(solicitudesDto.getMensaje())
                               .estado(solicitudesDto.getEstado())
                               .resena(solicitudesDto.getResena())
                               .estrellas(solicitudesDto.getEstrellas())
                               .build();
        return solicitudesRepository.save(solicitudes);           
    }

    @Transactional
    @Override
    public Solicitudes findById(Integer id) {
        
        return solicitudesRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Solicitudes solicitudes) {
        
        solicitudesRepository.delete(solicitudes);
    }

    @Override
    public boolean existsById(Integer id) {
        
        return solicitudesRepository.existsById(id);
    }
}
