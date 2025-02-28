package com.diegodev.agendamento.controllers.mappers.telefone;

import com.diegodev.agendamento.controllers.dto.telefone.requests.TelefoneRequestDTO;
import com.diegodev.agendamento.controllers.dto.telefone.responses.TelefoneResponseDTO;
import com.diegodev.agendamento.models.Telefone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {

    Telefone dtoParaTelefone(TelefoneRequestDTO dto);

    TelefoneResponseDTO telefoneParaDTO(Telefone telefone);
}
