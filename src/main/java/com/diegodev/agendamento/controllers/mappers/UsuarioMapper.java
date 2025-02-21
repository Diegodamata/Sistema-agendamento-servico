package com.diegodev.agendamento.controllers.mappers;

import com.diegodev.agendamento.controllers.dto.usuario.requests.*;
import com.diegodev.agendamento.models.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    
    Usuario dtoParaUsuario(UsuarioRequestDTO dto);
    UsuarioRequestDTO usuarioParaDto(Usuario usuario);
    
    List<Papel> dtoParaPapel(List<PapelUsuarioRequestDTO> papelDto);
    List<PapelUsuarioRequestDTO> papelParaDto(List<Papel> papel);
    
    ProfissionalInfo dtoParaProfissional(ProfissionalRequestDTO profissionalDto);
    ProfissionalRequestDTO profissionalParaDto(ProfissionalInfo profissional);
    
    List<Telefone> dtoParaTelefone(List<TelefoneRequestDTO> telefoneDto);
    List<TelefoneRequestDTO> telefoneParaDto(List<Telefone> telefone);
    
    List<Endereco> dtoParaEndereco(List<EnderecoRequestDTO> enderecoDto);
    List<EnderecoRequestDTO> enderecoParaDto(List<Endereco> endereco);

    
}
