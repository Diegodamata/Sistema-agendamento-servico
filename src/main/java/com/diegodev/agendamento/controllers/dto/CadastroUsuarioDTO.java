package com.diegodev.agendamento.controllers.dto;

import com.diegodev.agendamento.controllers.dto.endereco.EnderecoRequestDTO;
import com.diegodev.agendamento.controllers.dto.papel.PapelRequestDTO;
import com.diegodev.agendamento.controllers.dto.profissional.ProfissionalRequestDTO;
import com.diegodev.agendamento.controllers.dto.telefone.TelefoneRequestDTO;
import com.diegodev.agendamento.controllers.dto.usuario.requests.UsuarioRequestDTO;

import java.util.List;

public record CadastroUsuarioDTO(
        UsuarioRequestDTO usuario,
        List<PapelRequestDTO> papeis,
        ProfissionalRequestDTO profissional,
        List<TelefoneRequestDTO> telefones,
        List<EnderecoRequestDTO> enderecos
) {
}
