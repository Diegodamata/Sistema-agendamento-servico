package com.diegodev.agendamento.controllers.mappers.servico;

import com.diegodev.agendamento.controllers.dto.servico.ServicoDTO;
import com.diegodev.agendamento.models.Servico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    Servico dtoParaServico(ServicoDTO dto);

    ServicoDTO servicoParaDTO(Servico servico);
}
