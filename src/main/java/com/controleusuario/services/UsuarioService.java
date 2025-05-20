package com.controleusuario.services;

import com.controleusuario.dtos.UsuarioCreateDTO;
import com.controleusuario.entity.Role;
import com.controleusuario.entity.Usuario;
import com.controleusuario.exception.UserDataAlreadyExistsException;
import com.controleusuario.repositories.RoleRepository;
import com.controleusuario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final RoleRepository roleRepository;

    @Autowired
    public UsuarioService(UsuarioRepository repository, RoleRepository roleRepository){
        this.repository = repository;
        this.roleRepository = roleRepository;
    }

    public List<Usuario> getUsuarios(){
        return repository.findAll();
    }

    public Usuario createUsuario(UsuarioCreateDTO dto) {
        Optional<Usuario> emailExistente = repository.findByEmail(dto.email());
        if (emailExistente.isPresent()) {
            throw new UserDataAlreadyExistsException("E-mail já existe");
        }

        Role role = roleRepository.findByName(
                Optional.ofNullable(dto.roleName())
                        .orElseThrow(() -> new IllegalArgumentException("O campo 'roleName' não pode ser nulo ou vazio."))
        ).orElseThrow(() -> new IllegalArgumentException("Role não encontrada: " + dto.roleName()));

        Usuario usuario = new Usuario(dto, role);
        repository.save(usuario);
        return usuario;
    }

    public boolean updateUsuario(Long id, UsuarioCreateDTO dto){
        if (!repository.existsById(id))
            return false;

        Optional<Usuario> emailExistente = repository.findByEmail(dto.email());
        if (emailExistente.isPresent()) {
            throw new UserDataAlreadyExistsException("E-mail já se encontra em uso");
        }

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
