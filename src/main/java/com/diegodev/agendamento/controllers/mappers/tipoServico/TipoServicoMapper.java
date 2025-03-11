package com.diegodev.agendamento.controllers.mappers.tipoServico;

import com.diegodev.agendamento.controllers.dto.tipoServico.requests.TipoServicoRequestDTO;
import com.diegodev.agendamento.controllers.dto.tipoServico.responses.TipoServicoResponseDTO;
import com.diegodev.agendamento.models.TipoServico;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoServicoMapper {

    TipoServico dtoParaTipoServico(TipoServicoRequestDTO dto);

    TipoServicoResponseDTO tipoServicoParaResponseDTO(TipoServico tipoServico);

    List<TipoServicoResponseDTO> listTipoServicoParaListResponseDTO(List<TipoServico> tipoServico);
}
