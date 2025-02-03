package com.controleusuario.controllers;

import com.controleusuario.dtos.UsuarioCreateDTO;
import com.controleusuario.entity.Usuario;
import com.controleusuario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

//    private final UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<?> getUsuarios(){
        var allUsers = usuarioRepository.findAll();
        System.out.println(allUsers);
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody @Validated UsuarioCreateDTO usuarioCreateDTO){
        Usuario newUsuario = new Usuario(usuarioCreateDTO);
        System.out.println(usuarioCreateDTO);
        usuarioRepository.save(newUsuario);
        return ResponseEntity.ok().build();
    }
}