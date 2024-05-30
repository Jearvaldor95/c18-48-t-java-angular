package com.c1848tjavaangular.domi.controllers;

import com.c1848tjavaangular.domi.auth.jwt.JwtService;
import com.c1848tjavaangular.domi.dtos.SolicitudesDto;
import com.c1848tjavaangular.domi.services.SolicitudesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SolicitudesController {

    private final SolicitudesService solicitudesService;
    private final JwtService jwtService;

    public SolicitudesController(SolicitudesService solicitudesService, JwtService jwtService){
        this.solicitudesService = solicitudesService;
        this.jwtService = jwtService;
    }

    @GetMapping("/solicitud")
    public ResponseEntity<List<SolicitudesDto>> get(){
        return ResponseEntity.ok( solicitudesService.findAll());
    }

    @PostMapping("/solicitud")
    public ResponseEntity<SolicitudesDto> save(@RequestHeader("token") String token,@RequestBody SolicitudesDto solicitudesDto){
        Integer idUsuario = jwtService.getIdUsuarioFromToken(token);
        return new ResponseEntity<>(solicitudesService.save(idUsuario,solicitudesDto), HttpStatus.CREATED);
    }

    @PutMapping("/solicitud/{idSolicitud}")
    public ResponseEntity<SolicitudesDto> update(@PathVariable Integer idSolicitud,@RequestBody SolicitudesDto solicitudesDto){
        //Integer idUsuario = jwtService.getIdUsuarioFromToken(token);
        return new ResponseEntity<>(solicitudesService.update(idSolicitud,solicitudesDto), HttpStatus.OK);
    }

    @DeleteMapping("/solicitud/{id}")
    public ResponseEntity<SolicitudesDto> delete(@PathVariable Integer id){
        return ResponseEntity.ok(solicitudesService.delete(id));
    }

}
