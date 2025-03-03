package com.diegodev.agendamento.controllers.mappers.prossifional;

import com.diegodev.agendamento.controllers.dto.profissional.ProfissionalRequestDTO;
import com.diegodev.agendamento.models.ProfissionalInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfissionalMapper {

    ProfissionalInfo dtoParaProfissional(ProfissionalRequestDTO dto);
}
