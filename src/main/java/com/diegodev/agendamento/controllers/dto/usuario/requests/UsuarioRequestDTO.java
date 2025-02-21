package com.diegodev.agendamento.controllers.dto.usuario.requests;

public record UsuarioRequestDTO(

         String nome,
         String cpf,
         String email,
         String senha
) {
}
