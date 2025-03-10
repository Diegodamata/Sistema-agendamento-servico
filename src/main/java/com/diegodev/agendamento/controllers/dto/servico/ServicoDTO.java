package com.diegodev.agendamento.controllers.dto.servico;

import java.math.BigDecimal;

public record ServicoDTO(
        String nomeServico,
        String tempo,
        BigDecimal precoBase
) {
}
