package com.diegodev.agendamento.controllers.dto.servico;

import com.diegodev.agendamento.models.enums.StatusServico;

import java.math.BigDecimal;

public record ServicoDTO(
        String nomeServico,
        String tempo,
        BigDecimal precoBase,
        StatusServico statusServico
) {
}
