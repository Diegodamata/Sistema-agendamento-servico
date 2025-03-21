package com.diegodev.agendamento.controllers.mappers.endereco;

import com.diegodev.agendamento.controllers.dto.endereco.EnderecoRequestDTO;
import com.diegodev.agendamento.controllers.dto.endereco.EnderecoResponseDTO;
import com.diegodev.agendamento.models.Endereco;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    List<Endereco> listDeDTOParaListDeEndereco(List<EnderecoRequestDTO> dtos);

    Endereco dtoParaEndereco(EnderecoRequestDTO dto);

    EnderecoResponseDTO enderecoParaDTO(Endereco endereco);

    List<EnderecoResponseDTO> listEnderecoParaListEnderecoResponse (List<Endereco> endereco);
}
