package com.diegodev.agendamento.controllers.mappers.usuario;

import com.diegodev.agendamento.controllers.dto.usuario.requests.UsuarioRequestDTO;
import com.diegodev.agendamento.controllers.dto.usuario.responses.UsuarioDetalheResponseDTO;
import com.diegodev.agendamento.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    
    Usuario dtoParaUsuario(UsuarioRequestDTO dto);
    UsuarioRequestDTO usuarioParaDto(Usuario usuario);

    Usuario dtoRequestParaUsuario(UsuarioDetalheResponseDTO dto);
    UsuarioDetalheResponseDTO usuarioParaRequestDto(Usuario usuario);
}
