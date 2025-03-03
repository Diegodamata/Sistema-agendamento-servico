package com.diegodev.agendamento.controllers.dto.papel;

import com.diegodev.agendamento.models.enums.PapelUsuario;

public record PapelRequestDTO(
        PapelUsuario papelUsuario
) {
}
