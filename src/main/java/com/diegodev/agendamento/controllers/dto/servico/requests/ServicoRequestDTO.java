package com.diegodev.agendamento.controllers.dto.servico.requests;

import java.math.BigDecimal;

public record ServicoRequestDTO(
        String nomeServico,
        String tempo,
        BigDecimal precoBase
) {
}

