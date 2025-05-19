package com.controleusuario.controllers;

import com.controleusuario.dtos.UsuarioCreateDTO;
import com.controleusuario.entity.Usuario;
import com.controleusuario.repositories.UsuarioRepository;
import com.controleusuario.services.UsuarioService;
import jdk.javadoc.doclet.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping
    public ResponseEntity<?> getUsuarios(){
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody @Validated UsuarioCreateDTO usuarioCreateDTO){
        usuarioService.createUsuario(usuarioCreateDTO);
        return ResponseEntity.ok("Usuário criado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@PathVariable Long id, @RequestBody @Validated UsuarioCreateDTO usuarioUpdateDTO) {
        boolean atualizado = usuarioService.updateUsuario(id, usuarioUpdateDTO);
        if (!atualizado)
            return ResponseEntity.status(404).body("Usuário não encontrado!");

        return ResponseEntity.ok("Usuário atualizado com sucesso!");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
        boolean deletado = usuarioService.deleteUsuario(id);
        if (!deletado)
            return ResponseEntity.status(404).body("Usuário não encontrado!");

        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }

}