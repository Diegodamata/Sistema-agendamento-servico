package com.diegodev.agendamento.controllers.mappers.telefone;

import com.diegodev.agendamento.controllers.dto.telefone.requests.TelefoneRequestDTO;
import com.diegodev.agendamento.controllers.dto.telefone.responses.TelefoneResponseDTO;
import com.diegodev.agendamento.models.Telefone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {

    List<Telefone> listDeDToParaListTelefone(List<TelefoneRequestDTO> dtos);

    Telefone dtoParaTelefone(TelefoneRequestDTO dto);

    List<TelefoneResponseDTO> listDeTelefoneParaListTelefoneResponse(List<Telefone> telefones);

    TelefoneResponseDTO telefoneParaDTO(Telefone telefone);
}
