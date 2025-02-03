package com.controleusuario.services;

import com.controleusuario.dtos.UsuarioCreateDTO;
import com.controleusuario.entity.Usuario;
import com.controleusuario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

//    public Usuario findUsuarioById(Long id) throws Exception{
//        return this.repository.findUsuarioById(id).orElseThrow(() -> new Exception("Não foi possível encontrar usuário"));
//    }

//    public void saveUsuario(Usuario usuario){
//        this.repository.save(usuario);
//    }
//
//    public void createUsuario(UsuarioCreateDTO usuarioCreateDTO) throws Exception {
//        // Verificar se o e-mail já existe
//        if (repository.findAll().stream().anyMatch(usuario -> usuario.getEmail().equals(usuarioCreateDTO.email()))) {
//            throw new Exception("E-mail já cadastrado.");
//        }
//
//        // Criar a entidade Usuario a partir do DTO
//        Usuario usuario = new Usuario(
//                usuarioCreateDTO.primeiroNome(),
//                usuarioCreateDTO.ultimoNome(),
//                usuarioCreateDTO.cargo(),
//                usuarioCreateDTO.email()
//        );
//
//        // Salvar no banco de dados
//        repository.save(usuario);
//    }
}
