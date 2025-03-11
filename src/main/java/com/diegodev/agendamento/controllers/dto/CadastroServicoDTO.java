package com.diegodev.agendamento.controllers.dto;

import com.diegodev.agendamento.controllers.dto.servico.requests.ServicoRequestDTO;

import java.util.List;

public record CadastroServicoDTO(
        ServicoRequestDTO servico,
        List<String> tipoServico
) {
}
