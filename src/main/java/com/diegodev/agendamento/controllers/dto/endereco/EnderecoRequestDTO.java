package com.diegodev.agendamento.controllers.dto.endereco;

public record EnderecoRequestDTO(
        String cep,
        Integer numero,
        String cidade
) {
}
