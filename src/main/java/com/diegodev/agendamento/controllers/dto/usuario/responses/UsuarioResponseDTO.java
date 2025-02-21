package com.diegodev.agendamento.controllers.dto.usuario.responses;

import com.diegodev.agendamento.models.enums.StatusUsuario;

import java.time.LocalDateTime;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        StatusUsuario status,
        LocalDateTime dataCadastro
) {
}
