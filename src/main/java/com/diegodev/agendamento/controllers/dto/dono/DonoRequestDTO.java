package com.diegodev.agendamento.controllers.dto.dono;

import com.diegodev.agendamento.controllers.dto.telefone.requests.TelefoneRequestDTO;
import com.diegodev.agendamento.models.Usuario;

import java.util.List;

public record DonoRequestDTO(
        String nome,
        String email,
        String senha,
        List<TelefoneRequestDTO> telefones,
        String cnpj
) {

    public Usuario toUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return usuario;
    }
}
