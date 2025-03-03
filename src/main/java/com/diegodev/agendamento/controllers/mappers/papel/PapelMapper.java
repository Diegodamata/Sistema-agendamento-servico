package com.diegodev.agendamento.controllers.mappers.papel;

import com.diegodev.agendamento.controllers.dto.papel.PapelRequestDTO;
import com.diegodev.agendamento.models.Papel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PapelMapper {

    List<Papel> listDtoParaListPapel(List<PapelRequestDTO> dto);
}
