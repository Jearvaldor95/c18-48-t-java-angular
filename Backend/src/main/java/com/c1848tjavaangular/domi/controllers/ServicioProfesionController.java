package com.c1848tjavaangular.domi.controllers;

import com.c1848tjavaangular.domi.auth.jwt.JwtService;
import com.c1848tjavaangular.domi.dtos.ServicioProfesionDto;
import com.c1848tjavaangular.domi.services.ServicioProfesionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServicioProfesionController {

    private final ServicioProfesionService servicioProfesionService;
    private final JwtService jwtService;

    public ServicioProfesionController(ServicioProfesionService servicioProfesionService, JwtService jwtService){
        this.servicioProfesionService = servicioProfesionService;
        this.jwtService = jwtService;
    }

    @PostMapping("/servicio")
    public ResponseEntity<ServicioProfesionDto> save(@RequestHeader("token") String token, @RequestBody ServicioProfesionDto servicioProfesionDto){
        Integer idUsuario = jwtService.getIdUsuarioFromToken(token);
        return new ResponseEntity<>(servicioProfesionService.save(idUsuario, servicioProfesionDto), HttpStatus.CREATED);
    }
}
