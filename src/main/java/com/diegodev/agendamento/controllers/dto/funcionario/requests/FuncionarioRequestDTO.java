package com.diegodev.agendamento.controllers.dto.funcionario.requests;

import com.diegodev.agendamento.controllers.dto.telefone.requests.TelefoneRequestDTO;
import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.models.Usuario;

import java.util.List;

public record FuncionarioRequestDTO(
        String nome,
        String email,
        String senha,
        List<TelefoneRequestDTO> telefones,
        String cargo,
        String especialidade
) {

    public Usuario toUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return usuario;
    }
}
