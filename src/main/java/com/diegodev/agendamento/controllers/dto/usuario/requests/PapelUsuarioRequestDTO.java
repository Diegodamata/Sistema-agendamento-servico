package com.diegodev.agendamento.controllers.dto.usuario.requests;

import com.diegodev.agendamento.models.enums.StatusPapel;

public record PapelUsuarioRequestDTO(
        StatusPapel statusPapel
) {
}
