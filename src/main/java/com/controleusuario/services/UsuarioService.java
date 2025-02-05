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

}
