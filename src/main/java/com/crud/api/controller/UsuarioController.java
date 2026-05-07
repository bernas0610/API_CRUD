package com.crud.api.controller;

import com.crud.api.domain.Usuario;
import com.crud.api.dto.UsuarioDTO;
import com.crud.api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = Usuario.builder()
                .email(usuarioDTO.email())
                .nome(usuarioDTO.nome())
                .build();

        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){

        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail (@RequestParam String email){

        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuario(@RequestParam Integer id ,@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = Usuario.builder()
                .email(usuarioDTO.email())
                .nome(usuarioDTO.nome())
                .build();

        usuarioService.atualizarPorId(id , usuario);
        return ResponseEntity.ok().build();
    }
}
