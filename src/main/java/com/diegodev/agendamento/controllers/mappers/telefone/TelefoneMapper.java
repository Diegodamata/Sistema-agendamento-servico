package com.diegodev.agendamento.controllers.mappers.telefone;

import com.diegodev.agendamento.controllers.dto.telefone.TelefoneRequestDTO;
import com.diegodev.agendamento.controllers.dto.telefone.TelefoneResponseDTO;
import com.diegodev.agendamento.models.Telefone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {

    List<Telefone> listDtoParaListTelefone(List<TelefoneRequestDTO> dto);

    Telefone dtoParaTelefone(TelefoneRequestDTO dto);

    TelefoneResponseDTO telefoneParaDTO(Telefone telefone);
}
