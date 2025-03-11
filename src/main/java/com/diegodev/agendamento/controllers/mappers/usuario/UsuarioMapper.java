package com.diegodev.agendamento.controllers.mappers.usuario;

import com.diegodev.agendamento.controllers.dto.usuario.requests.UsuarioRequestDTO;
import com.diegodev.agendamento.controllers.dto.usuario.responses.UsuarioDetalheDTO;
import com.diegodev.agendamento.controllers.dto.usuario.responses.UsuarioResponseDTO;
import com.diegodev.agendamento.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    
    Usuario dtoRequestParaUsuario(UsuarioRequestDTO dto);

    UsuarioResponseDTO usuarioParaResponseDTO(Usuario usuario);
}
