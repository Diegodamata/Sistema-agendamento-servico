package com.diegodev.agendamento.controllers.dto.agendamento.requests;

import com.diegodev.agendamento.controllers.dto.agendamentoServico.requests.AgendamentoServicoRequestDTO;

import java.time.LocalDateTime;
import java.util.List;

public record AgendamentoRequestDTO(
        LocalDateTime dataAgendamento,
        Long usuarioId,
        List<AgendamentoServicoRequestDTO> servicos
) {
}
