package com.controleusuario.entity;

import com.controleusuario.dtos.UsuarioCreateDTO;
import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String primeiroNome;
    private String ultimoNome;
    private String cargo;
    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEmail() {
        return email;
    }

    public Usuario(String primeiroNome, String ultimoNome, String cargo, String email) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.cargo = cargo;
        this.email = email;
    }

    public Usuario(){

    }

    public Usuario(UsuarioCreateDTO usuarioCreateDTO, Role role) {
        this.primeiroNome = usuarioCreateDTO.primeiroNome();
        this.ultimoNome = usuarioCreateDTO.ultimoNome();
        this.cargo = usuarioCreateDTO.cargo();
        this.email = usuarioCreateDTO.email();
        this.role = role;
    }
}
