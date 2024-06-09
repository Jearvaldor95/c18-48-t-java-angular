package com.c1848tjavaangular.domi.controllers;

import com.c1848tjavaangular.domi.auth.jwt.JwtService;
import com.c1848tjavaangular.domi.dtos.ServicioProfesionDto;
import com.c1848tjavaangular.domi.dtos.ServiciosUsuarioDto;
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

    @GetMapping("/servicio-profesion")
    public ResponseEntity<?> getServiciosAndUsuarios(){
        return ResponseEntity.ok(servicioProfesionService.findAllServiciosAndUsuarios());
    }
    
    @GetMapping("/servicio-profesion/nombre")
    public ResponseEntity<?> getProfesional(@RequestParam String nombreServicio){
       return ResponseEntity.ok(servicioProfesionService.findByServiciosNombre(nombreServicio));
    }

    @PostMapping("/servicio-profesion")
    public ResponseEntity<ServicioProfesionDto> save(@RequestHeader("token") String token, @RequestBody ServicioProfesionDto servicioProfesionDto){
        Integer idUsuario = jwtService.getIdUsuarioFromToken(token);
        return new ResponseEntity<>(servicioProfesionService.save(idUsuario, servicioProfesionDto), HttpStatus.CREATED);
    }

    @GetMapping("/servicio-profesion/nombre-direccion")
    public ResponseEntity<?> getServiciosNombreAndUsuariosDireccion(@RequestParam String nombreServicio, @RequestParam String direccion){
        return ResponseEntity.ok(servicioProfesionService.findByServiciosNombreAndUsuariosDireccion(nombreServicio, direccion));
    }

    @GetMapping("/servicio-profesion/direccion")
    public ResponseEntity<?> getUsuariosDireccion(@RequestParam String direccion){
        return ResponseEntity.ok(servicioProfesionService.findByUsuariosDireccion(direccion));
    }

    @DeleteMapping("/servicio-profesion/{id}")
    public ResponseEntity<ServicioProfesionDto> delete(@PathVariable Integer id){
        return ResponseEntity.ok(servicioProfesionService.delete(id));
    }
}
