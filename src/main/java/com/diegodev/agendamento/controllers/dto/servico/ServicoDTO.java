package com.diegodev.agendamento.controllers.dto.servico;

import com.diegodev.agendamento.models.TipoServico;

import java.math.BigDecimal;
import java.util.List;

public record ServicoDTO(
        String nomeServico,
        String tempo,
        BigDecimal precoBase,
        List<TipoServico> tipoServico
) {
}
