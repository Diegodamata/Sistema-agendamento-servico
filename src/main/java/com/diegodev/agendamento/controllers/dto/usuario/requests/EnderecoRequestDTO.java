package com.diegodev.agendamento.controllers.dto.usuario.requests;

public record EnderecoRequestDTO(
        String cep,
        Integer numero,
        String complemento,
        String cidade,
        String rua
) {
}
