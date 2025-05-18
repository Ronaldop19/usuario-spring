package com.controleusuario.services;

import com.controleusuario.dtos.UsuarioCreateDTO;
import com.controleusuario.entity.Usuario;
import com.controleusuario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public List<Usuario> getUsuarios(){
        return repository.findAll();
    }

    public void createUsuario(UsuarioCreateDTO dto) {
        Usuario usuario = new Usuario(dto);
        repository.save(usuario);
    }

    public boolean updateUsuario(Long id, UsuarioCreateDTO dto){
        if (!repository.existsById(id))
            return false;

        Usuario usuario = repository.getReferenceById(id);
        usuario.setPrimeiroNome(dto.primeiroNome());
        usuario.setUltimoNome(dto.ultimoNome());
        usuario.setCargo(dto.cargo());
        usuario.setEmail(dto.email());
        repository.save(usuario);

        return true;
    }

    public boolean deleteUsuario(Long id){
        if (!repository.existsById(id))
            return false;

        repository.deleteById(id);

        return true;
    }

}
