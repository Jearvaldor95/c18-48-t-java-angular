package com.c1848tjavaangular.domi.controllers;

import com.c1848tjavaangular.domi.auth.jwt.JwtService;
import com.c1848tjavaangular.domi.dtos.PasswordDto;
import com.c1848tjavaangular.domi.dtos.UsuariosDto;
import com.c1848tjavaangular.domi.services.UsuariosService;
import com.c1848tjavaangular.domi.services.impl.UploadFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UsuariosController {

    private final UsuariosService usuariosService;
    private final JwtService jwtService;
    private final UploadFileService uploadFileService;

    public UsuariosController(UsuariosService usuariosService, JwtService jwtService, UploadFileService uploadFileService){
        this.usuariosService = usuariosService;
        this.jwtService = jwtService;
        this.uploadFileService = uploadFileService;
    }
    @PutMapping(value = "/usuario/{idUsuario}",consumes = "multipart/form-data")
    public ResponseEntity<?> updatePerfil(@RequestPart("foto") MultipartFile foto,@PathVariable Integer idUsuario, @RequestPart UsuariosDto usuariosDto) throws IOException {
        String nombreFoto = uploadFileService.saveFoto(foto);
        usuariosDto.setFoto(nombreFoto);
        usuariosService.updatePerfil(idUsuario, usuariosDto);
        return ResponseEntity.ok().body("Perfil actualizado!");
    }

    @PutMapping("/usuario/password")
    public ResponseEntity<?> updatePassword(@RequestHeader("token") String token, @RequestBody PasswordDto passworDto) {
        Integer idUsuario = jwtService.getIdUsuarioFromToken(token);
        usuariosService.updatePassword(idUsuario, passworDto);
        return ResponseEntity.ok().body("Contraseña actualizada! ");
    }

    @GetMapping("/usuario/perfil")
    public ResponseEntity<?> getUsuario(@RequestHeader("token") String token){
        Integer idUsuario = jwtService.getIdUsuarioFromToken(token);
        return ResponseEntity.ok(usuariosService.findById(idUsuario));
    }
}
