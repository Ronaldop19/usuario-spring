package com.controleusuario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="usuario")
@Table(name="usuario")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String primeiroNome;
    private String ultimoNome;
    @Column(unique = true)
    private String email;
}
