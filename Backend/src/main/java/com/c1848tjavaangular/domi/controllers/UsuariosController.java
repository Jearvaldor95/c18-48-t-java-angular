package com.c1848tjavaangular.domi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c1848tjavaangular.domi.models.entities.Usuarios;
import com.c1848tjavaangular.domi.services.UsuariosService;

@RestController
@RequestMapping("/api/v1")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("usuarios")
    public ResponseEntity<?>showAll(){
        List<Usuarios> getList = usuariosService.listAll();
        
        return new ResponseEntity<>(getList, HttpStatus.OK);
    }
}
