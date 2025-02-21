package com.diegodev.agendamento.controllers.dto.usuario.requests;

import java.util.List;

public record CadastroUsuarioDTO(
        UsuarioRequestDTO usuario,
        List<PapelUsuarioRequestDTO> papel,
        ProfissionalRequestDTO profissional,
        List<TelefoneRequestDTO> telefone,
        List<EnderecoRequestDTO> endereco
) {
}
