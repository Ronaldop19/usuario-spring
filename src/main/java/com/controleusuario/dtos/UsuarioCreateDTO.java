package com.controleusuario.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCreateDTO(
        Long id,

        @NotBlank(message = "O primeiro nome não pode estar vazio.")
        @Size(min = 2, max = 50, message = "O primeiro nome deve ter entre 2 e 50 caracteres.")
        String primeiroNome,

        @Size(max = 50, message = "O sobrenome deve ter no máximo 50 caracteres.")
        String ultimoNome,

        @Size(max = 100, message = "O cargo deve ter no máximo 100 caracteres.")
        String cargo,

        @NotBlank(message = "O email é obrigatório.")
        @Size(max = 100, message = "O email deve ter no máximo 100 caracteres.")
        String email
) {}