package com.diegodev.agendamento.controllers.dto.cliente.responses;

import com.diegodev.agendamento.models.enums.StatusUsuario;

import java.time.LocalDate;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        StatusUsuario status,
        LocalDate dataCadastro
) {
}
