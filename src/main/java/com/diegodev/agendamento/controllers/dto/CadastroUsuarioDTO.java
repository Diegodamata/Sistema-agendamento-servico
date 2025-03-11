package com.diegodev.agendamento.controllers.dto;

import com.diegodev.agendamento.controllers.dto.endereco.EnderecoRequestDTO;
import com.diegodev.agendamento.controllers.dto.profissional.ProfissionalRequestDTO;
import com.diegodev.agendamento.controllers.dto.telefone.requests.TelefoneRequestDTO;
import com.diegodev.agendamento.controllers.dto.usuario.requests.UsuarioRequestDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CadastroUsuarioDTO(
        UsuarioRequestDTO usuario,
        List<String> roles,
        ProfissionalRequestDTO profissional,
        List<TelefoneRequestDTO> telefones,
        List<EnderecoRequestDTO> enderecos
) {
}
