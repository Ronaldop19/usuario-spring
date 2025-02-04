package com.controleusuario.controllers;

import com.controleusuario.dtos.UsuarioCreateDTO;
import com.controleusuario.entity.Usuario;
import com.controleusuario.repositories.UsuarioRepository;
import jdk.javadoc.doclet.Reporter;
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
        usuarioRepository.save(newUsuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@PathVariable Long id, @RequestBody @Validated UsuarioCreateDTO usuarioUpdateDTO) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.status(404).body("Usuário não encontrado!");
        }

        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.setPrimeiroNome(usuarioUpdateDTO.primeiroNome());
        usuario.setUltimoNome(usuarioUpdateDTO.ultimoNome());
        usuario.setCargo(usuarioUpdateDTO.cargo());
        usuario.setEmail(usuarioUpdateDTO.email());

        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Usuário atualizado com sucesso!");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.status(404).body("Usuário não encontrado!");
        }

        usuarioRepository.deleteById(id);
        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }

}