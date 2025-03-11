package com.diegodev.agendamento.controllers.dto.servico.responses;

import java.math.BigDecimal;

public record ServicoResponseDTO (
        Long id,
        String nomeServico,
        String tempo,
        BigDecimal precoBase
){
}
