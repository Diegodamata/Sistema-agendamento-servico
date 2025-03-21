package com.diegodev.agendamento.controllers.mappers.prossifional;

import com.diegodev.agendamento.controllers.dto.profissional.ProfissionalRequestDTO;
import com.diegodev.agendamento.controllers.dto.usuario.requests.UsuarioRequestDTO;
import com.diegodev.agendamento.models.Profissional;
import com.diegodev.agendamento.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfissionalMapper {

    Profissional dtoParaProfissional(ProfissionalRequestDTO dto);

    Usuario dtoRequestParaUsuario(UsuarioRequestDTO dto);
}
